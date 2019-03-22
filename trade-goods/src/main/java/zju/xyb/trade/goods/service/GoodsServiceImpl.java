package zju.xyb.trade.goods.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import zju.xyb.trade.common.constant.RetEnum;
import zju.xyb.trade.common.protocol.goods.ChangeStoreReq;
import zju.xyb.trade.common.protocol.goods.ChangeStoreRes;
import zju.xyb.trade.common.protocol.goods.QueryGoodsReq;
import zju.xyb.trade.common.protocol.goods.QueryGoodsRes;
import zju.xyb.trade.common.service.IGoodsService;
import zju.xyb.trade.dao.entity.TradeGoods;
import zju.xyb.trade.dao.mapper.TradeGoodsMapper;

public class GoodsServiceImpl implements IGoodsService{

    @Autowired
    private TradeGoodsMapper tradeGoodsMapper;

    public QueryGoodsRes queryGoodsById(QueryGoodsReq queryGoodsReq) {
        System.out.println("--------------查询商品服务被调用-----------------");
        QueryGoodsRes queryGoodsRes = new QueryGoodsRes();
        try {
            if (queryGoodsReq == null || queryGoodsReq.getGoodsId() == null) {
                throw new RuntimeException("查询商品请求参数不正确");
            }
            TradeGoods tradeGoods = tradeGoodsMapper.selectByPrimaryKey(queryGoodsReq.getGoodsId());
            if (tradeGoods != null) {
                BeanUtils.copyProperties(tradeGoods, queryGoodsRes);
                queryGoodsRes.setRetCode(RetEnum.SUCCESS.getCode());
                queryGoodsRes.setRetInfo(RetEnum.SUCCESS.getDesc());
            } else {
                throw new RuntimeException("查询不到此商品");
            }
        } catch (Exception e) {
            e.printStackTrace();
            queryGoodsRes.setRetCode(RetEnum.FAILED.getCode());
            queryGoodsRes.setRetInfo(RetEnum.FAILED.getDesc());
        }
        return queryGoodsRes;
    }

    public ChangeStoreRes changeStore(ChangeStoreReq changeStoreReq) {
        return null;
    }
}
