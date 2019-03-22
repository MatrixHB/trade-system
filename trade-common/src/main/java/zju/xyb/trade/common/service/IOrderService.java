package zju.xyb.trade.common.service;

import zju.xyb.trade.common.protocol.order.ConfirmOrderReq;
import zju.xyb.trade.common.protocol.order.ConfirmOrderRes;

public interface IOrderService {

    ConfirmOrderRes confirmOrder(ConfirmOrderReq confirmOrderReq);
}
