package zju.xyb.trade.common.constant;

public enum RetEnum {
    SUCCESS("1","请求返回成功"),FAILED("-1","请求返回失败");

    private String code;
    private String desc;

    RetEnum(String code, String desc) {
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
