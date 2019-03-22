package zju.xyb.trade.common.service;

import zju.xyb.trade.common.protocol.goods.ChangeStoreReq;
import zju.xyb.trade.common.protocol.goods.ChangeStoreRes;
import zju.xyb.trade.common.protocol.goods.QueryGoodsReq;
import zju.xyb.trade.common.protocol.goods.QueryGoodsRes;

public interface IGoodsService {

    QueryGoodsRes queryGoodsById(QueryGoodsReq queryGoodsReq);

    ChangeStoreRes changeStore(ChangeStoreReq changeStoreReq);
}
