package zju.xyb.trade.common.protocol.goods;

import java.io.Serializable;

public class ChangeStoreReq implements Serializable {

    private static final long serialVersionUID = -1934616683545362775L;

    private String goodsId;

    private Integer goodsNumber;

    private String orderId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
