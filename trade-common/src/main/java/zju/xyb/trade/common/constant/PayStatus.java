package zju.xyb.trade.common.constant;

public enum PayStatus {

    NOT_PAID("0","未支付"),
    PAYING("1","支付中"),
    PAID("2","支付完成");

    private String code;
    private String desc;

    PayStatus(String code, String desc) {
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
