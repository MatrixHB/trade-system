package zju.xyb.trade.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TradeUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_id
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_name
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_password
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_contact
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private String userContact;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_score
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private Integer userScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_balance
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private BigDecimal userBalance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade..trade_user.user_reg_time
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    private Date userRegTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_id
     *
     * @return the value of trade..trade_user.user_id
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_id
     *
     * @param userId the value for trade..trade_user.user_id
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_name
     *
     * @return the value of trade..trade_user.user_name
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_name
     *
     * @param userName the value for trade..trade_user.user_name
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_password
     *
     * @return the value of trade..trade_user.user_password
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_password
     *
     * @param userPassword the value for trade..trade_user.user_password
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_contact
     *
     * @return the value of trade..trade_user.user_contact
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public String getUserContact() {
        return userContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_contact
     *
     * @param userContact the value for trade..trade_user.user_contact
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserContact(String userContact) {
        this.userContact = userContact == null ? null : userContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_score
     *
     * @return the value of trade..trade_user.user_score
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public Integer getUserScore() {
        return userScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_score
     *
     * @param userScore the value for trade..trade_user.user_score
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_balance
     *
     * @return the value of trade..trade_user.user_balance
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public BigDecimal getUserBalance() {
        return userBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_balance
     *
     * @param userBalance the value for trade..trade_user.user_balance
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserBalance(BigDecimal userBalance) {
        this.userBalance = userBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade..trade_user.user_reg_time
     *
     * @return the value of trade..trade_user.user_reg_time
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public Date getUserRegTime() {
        return userRegTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade..trade_user.user_reg_time
     *
     * @param userRegTime the value for trade..trade_user.user_reg_time
     *
     * @mbg.generated Thu Mar 21 23:40:45 CST 2019
     */
    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }
}