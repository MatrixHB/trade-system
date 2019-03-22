package zju.xyb.trade.common.constant;

public enum OrderStatus {

    NOT_CONFIRMED("0","订单未确认"),
    CONFIRMED("1","订单已确认"),
    CANCELED("2","订单已取消"),
    RETURNED("3","退货");

    private String code;
    private String desc;

    OrderStatus(String code, String desc) {
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
