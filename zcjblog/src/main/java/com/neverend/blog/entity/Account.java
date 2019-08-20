package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Account implements Serializable {
    public static final String STATE_NORMAL = "����";
    public static final String STATE_DISABLE = "����";
    public static final String STATE_LOCKED = "����";
    /**
     * ����
     */
    private String id;

    /**
     * �û���
     */
    private String userName;

    /**
     * ����
     */
    private String userPassword;

    /**
     * ����
     */
    private String userEmail;

    /**
     * �ֻ�
     */
    private Integer cellphoneNumber;

    /**
     * ����id
     */
    private String articleId;

    /**
     * ����ʱ��
     */
    private Date creatTime;

    /**
     * ����¼ʱ��
     */
    private Date loginEndTime;

    /**
     * �˺�״̬��������������
     */
    private String accountState;
    /**
     * ��ɫ
     */
    private List<Roles> rolesList;

    /**
     * �û����
     */
    private String beiYongEr;

    private String beiYongSan;

    private String beiYongSi;

    private String beiYongWu;

    private String beiYongLiu;

    private String beiYongQi;

    private String beiYongBa;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(Integer cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLoginEndTime() {
        return loginEndTime;
    }

    public void setLoginEndTime(Date loginEndTime) {
        this.loginEndTime = loginEndTime;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public String getBeiYongEr() {
        return beiYongEr;
    }

    public void setBeiYongEr(String beiYongEr) {
        this.beiYongEr = beiYongEr;
    }

    public String getBeiYongSan() {
        return beiYongSan;
    }

    public void setBeiYongSan(String beiYongSan) {
        this.beiYongSan = beiYongSan;
    }

    public String getBeiYongSi() {
        return beiYongSi;
    }

    public void setBeiYongSi(String beiYongSi) {
        this.beiYongSi = beiYongSi;
    }

    public String getBeiYongWu() {
        return beiYongWu;
    }

    public void setBeiYongWu(String beiYongWu) {
        this.beiYongWu = beiYongWu;
    }

    public String getBeiYongLiu() {
        return beiYongLiu;
    }

    public void setBeiYongLiu(String beiYongLiu) {
        this.beiYongLiu = beiYongLiu;
    }

    public String getBeiYongQi() {
        return beiYongQi;
    }

    public void setBeiYongQi(String beiYongQi) {
        this.beiYongQi = beiYongQi;
    }

    public String getBeiYongBa() {
        return beiYongBa;
    }

    public void setBeiYongBa(String beiYongBa) {
        this.beiYongBa = beiYongBa;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", cellphoneNumber=" + cellphoneNumber +
                ", articleId='" + articleId + '\'' +
                ", creatTime=" + creatTime +
                ", loginEndTime=" + loginEndTime +
                ", accountState='" + accountState + '\'' +
                ", rolesList=" + rolesList +
                ", beiYongEr='" + beiYongEr + '\'' +
                ", beiYongSan='" + beiYongSan + '\'' +
                ", beiYongSi='" + beiYongSi + '\'' +
                ", beiYongWu='" + beiYongWu + '\'' +
                ", beiYongLiu='" + beiYongLiu + '\'' +
                ", beiYongQi='" + beiYongQi + '\'' +
                ", beiYongBa='" + beiYongBa + '\'' +
                '}';
    }
}