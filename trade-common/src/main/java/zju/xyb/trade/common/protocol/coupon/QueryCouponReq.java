package zju.xyb.trade.common.protocol.coupon;

import java.io.Serializable;

public class QueryCouponReq implements Serializable {

    private static final long serialVersionUID = -4260678541618008928L;

    private String couponId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
