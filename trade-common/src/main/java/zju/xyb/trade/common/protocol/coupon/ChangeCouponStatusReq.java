package zju.xyb.trade.common.protocol.coupon;

import java.io.Serializable;

public class ChangeCouponStatusReq implements Serializable {

    private static final long serialVersionUID = -4147158425923077859L;

    private String couponId;

    private boolean isUsed;

    private String orderId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
