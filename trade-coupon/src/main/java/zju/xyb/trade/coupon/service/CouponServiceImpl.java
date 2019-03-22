package zju.xyb.trade.coupon.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zju.xyb.trade.common.constant.RetEnum;
import zju.xyb.trade.common.protocol.coupon.ChangeCouponStatusReq;
import zju.xyb.trade.common.protocol.coupon.ChangeCouponStatusRes;
import zju.xyb.trade.common.protocol.coupon.QueryCouponReq;
import zju.xyb.trade.common.protocol.coupon.QueryCouponRes;
import zju.xyb.trade.common.service.ICouponService;
import zju.xyb.trade.dao.entity.TradeCoupon;
import zju.xyb.trade.dao.mapper.TradeCouponMapper;

public class CouponServiceImpl implements ICouponService {

    @Autowired
    private TradeCouponMapper tradeCouponMapper;

    public QueryCouponRes queryCouponById(QueryCouponReq queryCouponReq) {
        System.out.println("--------------查询优惠券服务被调用-----------------");
        QueryCouponRes queryCouponRes = new QueryCouponRes();
        try {
            if (queryCouponReq == null || queryCouponReq.getCouponId() == null) {
                throw new RuntimeException("查询优惠券请求参数不正确");
            }
            TradeCoupon tradeCoupon = tradeCouponMapper.selectByPrimaryKey(queryCouponReq.getCouponId());
            if (tradeCoupon != null) {
                BeanUtils.copyProperties(tradeCoupon, queryCouponRes);
                queryCouponRes.setRetCode(RetEnum.SUCCESS.getCode());
                queryCouponRes.setRetInfo(RetEnum.SUCCESS.getDesc());
            } else {
                throw new RuntimeException("未查询到该优惠券");
            }
        } catch (Exception e) {
            e.printStackTrace();
            queryCouponRes.setRetCode(RetEnum.FAILED.getCode());
            queryCouponRes.setRetInfo(RetEnum.FAILED.getDesc());
        }

        return queryCouponRes;
    }

    public ChangeCouponStatusRes changeCouponStatus(ChangeCouponStatusReq changeCouponStatusReq) {
        return null;
    }
}
