package zju.xyb.trade.common.protocol.user;

import zju.xyb.trade.common.protocol.BaseRes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class QueryUserRes extends BaseRes {

    private Integer userId;

    private String userName;

    private String userContact;

    private Integer userScore;

    private BigDecimal userBalance;

    private Date userRegTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public BigDecimal getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    @Override
    public String toString() {
        return "QueryUserRes{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userContact='" + userContact + '\'' +
                ", userScore=" + userScore +
                ", userBalance=" + userBalance +
                ", userRegTime=" + userRegTime +
                '}';
    }
}
