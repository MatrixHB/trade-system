package zju.xyb.trade.common.protocol.goods;

import zju.xyb.trade.common.protocol.BaseRes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QueryGoodsRes extends BaseRes implements Serializable {

    private static final long serialVersionUID = -5361925812194235523L;

    private String goodsId;

    private String goodsName;

    private Integer goodsStore;

    private BigDecimal goodsPrice;

    private Date addTime;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsStore() {
        return goodsStore;
    }

    public void setGoodsStore(Integer goodsStore) {
        this.goodsStore = goodsStore;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
