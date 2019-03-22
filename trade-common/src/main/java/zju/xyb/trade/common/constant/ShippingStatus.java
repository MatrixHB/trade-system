package zju.xyb.trade.common.constant;

public enum ShippingStatus {

    NOT_SENT("0","未发货"),
    SHIPPING("1","运货中"),
    RECEIVED("2","已收货");

    private String code;
    private String desc;

    ShippingStatus(String code, String desc) {
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
