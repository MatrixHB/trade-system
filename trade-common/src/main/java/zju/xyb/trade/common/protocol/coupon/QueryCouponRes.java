package zju.xyb.trade.common.protocol.coupon;

import zju.xyb.trade.common.protocol.BaseRes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QueryCouponRes extends BaseRes implements Serializable {

    private static final long serialVersionUID = 5931360336349515453L;

    private String couponId;

    private BigDecimal couponPrice;

    private Integer userId;

    private String isUsed;

    private Date usedTime;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    @Override
    public String toString() {
        return "QueryCouponRes{" +
                "couponId='" + couponId + '\'' +
                ", couponPrice=" + couponPrice +
                ", userId=" + userId +
                ", isUsed=" + isUsed +
                ", usedTime=" + usedTime +
                '}';
    }
}
