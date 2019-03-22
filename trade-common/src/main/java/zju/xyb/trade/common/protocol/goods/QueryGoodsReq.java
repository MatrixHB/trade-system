package zju.xyb.trade.common.protocol.goods;

import java.io.Serializable;

public class QueryGoodsReq implements Serializable {

    private static final long serialVersionUID = -7833377722446361501L;

    private String goodsId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
