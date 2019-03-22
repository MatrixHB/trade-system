package zju.xyb.trade.common.service;

import zju.xyb.trade.common.protocol.coupon.ChangeCouponStatusReq;
import zju.xyb.trade.common.protocol.coupon.ChangeCouponStatusRes;
import zju.xyb.trade.common.protocol.coupon.QueryCouponReq;
import zju.xyb.trade.common.protocol.coupon.QueryCouponRes;

public interface ICouponService {

    QueryCouponRes queryCouponById(QueryCouponReq queryCouponReq);

    ChangeCouponStatusRes changeCouponStatus(ChangeCouponStatusReq changeCouponStatusReq);
}
