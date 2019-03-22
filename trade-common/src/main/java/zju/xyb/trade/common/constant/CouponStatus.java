package zju.xyb.trade.common.constant;

public enum CouponStatus {

    NOT_USED("0","优惠券未使用"),
    USED("1","优惠券已使用"),
    INVALID("2","优惠券已失效");

    private String code;
    private String desc;

    CouponStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
