package zju.xyb.trade.order.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.xyb.trade.common.constant.*;
import zju.xyb.trade.common.exception.TradeOrderException;
import zju.xyb.trade.common.protocol.coupon.QueryCouponReq;
import zju.xyb.trade.common.protocol.coupon.QueryCouponRes;
import zju.xyb.trade.common.protocol.goods.QueryGoodsReq;
import zju.xyb.trade.common.protocol.goods.QueryGoodsRes;
import zju.xyb.trade.common.protocol.order.ConfirmOrderReq;
import zju.xyb.trade.common.protocol.order.ConfirmOrderRes;
import zju.xyb.trade.common.service.ICouponService;
import zju.xyb.trade.common.service.IGoodsService;
import zju.xyb.trade.common.service.IOrderService;
import zju.xyb.trade.dao.entity.TradeOrder;
import zju.xyb.trade.dao.mapper.TradeOrderMapper;
import zju.xyb.trade.order.util.IdGenerator;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICouponService couponService;

    @Autowired
    private TradeOrderMapper tradeOrderMapper;

    public ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq) {
        ConfirmOrderRes confirmOrderRes = new ConfirmOrderRes();

        try {
            // 1、下单前的商品信息检验（库存、价格等）
            checkOrderGoods(confirmOrderReq);

            // 2、检验订单的其他请求参数
            checkOrderReqParams(confirmOrderReq);

            // 3、创建不可见订单
            TradeOrder tradeOrder = createNotConfirmedOrder(confirmOrderReq);
            saveNotConfirmedOrder(tradeOrder);

            // 4、调用远程服务，使用优惠券、减库存，如果成功，则修改订单为可见，否则回滚操作


        } catch (Exception e) {
            e.printStackTrace();
            confirmOrderRes.setRetCode(RetEnum.FAILED.getCode());
            confirmOrderRes.setRetInfo(RetEnum.FAILED.getDesc());
        }

        return confirmOrderRes;
    }

    private void checkOrderGoods(ConfirmOrderReq confirmOrderReq) {
        if(confirmOrderReq == null) {
            throw new TradeOrderException("下单信息不能为空");
        }
        if(confirmOrderReq.getGoodsId() == null) {
            throw new TradeOrderException("商品编号不能为空");
        }
        // 调用远程服务，查看商品库存
        QueryGoodsReq queryGoodsReq = new QueryGoodsReq();
        queryGoodsReq.setGoodsId(confirmOrderReq.getGoodsId());
        QueryGoodsRes queryGoodsRes = goodsService.queryGoodsById(queryGoodsReq);
        if (queryGoodsRes.getGoodsId() == null || queryGoodsRes.getRetCode().equals(RetEnum.FAILED.getCode())) {
            throw new TradeOrderException("未查询到该商品：[" + confirmOrderReq.getGoodsId() + "]");
        }
        if (queryGoodsRes.getGoodsStore() < confirmOrderReq.getGoodsNum()) {
            throw new TradeOrderException("商品库存不足：[" + confirmOrderReq.getGoodsId() + "]");
        }
        if (queryGoodsRes.getGoodsPrice().compareTo(confirmOrderReq.getGoodsPrice()) != 0) {
            throw new TradeOrderException("商品价格有变化");
        }
    }

    private void checkOrderReqParams(ConfirmOrderReq confirmOrderReq) {
        if (confirmOrderReq.getUserId() == null) {
            throw new TradeOrderException("用户ID不能为空");
        }
        if (confirmOrderReq.getAddress() == null) {
            throw new TradeOrderException("收货地址不能为空");
        }
        if (confirmOrderReq.getConsignee() == null) {
            throw new TradeOrderException("收货人不能为空");
        }
        if (confirmOrderReq.getGoodsNum() == null || confirmOrderReq.getGoodsNum() <= 0) {
            throw new TradeOrderException("购买数量不能小于零");
        }
        if (confirmOrderReq.getShippingFee() == null || confirmOrderReq.getShippingFee().compareTo(BigDecimal.ZERO) == -1) {
            confirmOrderReq.setShippingFee(BigDecimal.ZERO);
        }

    }

    private TradeOrder createNotConfirmedOrder(ConfirmOrderReq confirmOrderReq) {
        TradeOrder tradeOrder = new TradeOrder();
        BeanUtils.copyProperties(confirmOrderReq, tradeOrder);
        tradeOrder.setOrderId(IdGenerator.generateOrderId());
        tradeOrder.setOrderStatus(OrderStatus.NOT_CONFIRMED.getCode());
        tradeOrder.setPayStatus(PayStatus.NOT_PAID.getCode());
        tradeOrder.setShippingStatus(ShippingStatus.NOT_SENT.getCode());

        // 计算金额
        BigDecimal goodsAmount = confirmOrderReq.getGoodsPrice().multiply(new BigDecimal(confirmOrderReq.getGoodsNum()));
        tradeOrder.setGoodsAmount(goodsAmount);
        BigDecimal orderAmount = goodsAmount.add(confirmOrderReq.getShippingFee());
        tradeOrder.setOrderAmount(orderAmount);

        // 检查优惠券
        String couponId = confirmOrderReq.getCouponId();
        if (StringUtils.isNotEmpty(couponId)) {
            QueryCouponRes queryCouponRes = checkOrderCoupon(couponId);
            BigDecimal couponPaid = queryCouponRes.getCouponPrice();
            tradeOrder.setCouponPaid(couponPaid);
            tradeOrder.setPayAmount(orderAmount.subtract(couponPaid));
        }

        tradeOrder.setMoneyPaid(BigDecimal.ZERO);
        tradeOrder.setAddTime(new Date());
        return tradeOrder;
    }

    private QueryCouponRes checkOrderCoupon(String couponId) {
        QueryCouponReq queryCouponReq = new QueryCouponReq();
        queryCouponReq.setCouponId(couponId);
        QueryCouponRes queryCouponRes = couponService.queryCouponById(queryCouponReq);
        if (queryCouponRes == null || queryCouponRes.getRetCode().equals(RetEnum.FAILED.getCode())) {
            throw new TradeOrderException("未查询到该优惠券");
        }
        if (queryCouponRes.getCouponPrice() == null ) {
            throw new TradeOrderException("此优惠券金额异常");
        }
        if ( queryCouponRes.getIsUsed().equals(CouponStatus.USED.getCode())) {
            throw new TradeOrderException("此优惠券已使用");
        }
        if ( queryCouponRes.getIsUsed().equals(CouponStatus.INVALID.getCode())) {
            throw new TradeOrderException("此优惠券已过期");
        }
        return queryCouponRes;
    }

    private void saveNotConfirmedOrder(TradeOrder tradeOrder) {
        tradeOrderMapper.insertSelective(tradeOrder);
    }

}
