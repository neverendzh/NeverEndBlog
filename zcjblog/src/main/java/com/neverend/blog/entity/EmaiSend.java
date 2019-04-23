package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class EmaiSend implements Serializable {
    private String id;

    /**
     * 发件人
     */
    private String sendEmailNumber;

    /**
     * 收件人
     */
    private String revenueEmailNumber;

    /**
     * 邮件主题
     */
    private String emailSubject;

    /**
     * 附件信息
     */
    private String emailFuJian;

    private Date beiYongTime;

    /**
     *  发送时间
     */
    private Date sendTime;

    /**
     * 发送状态
     */
    private String type;

    /**
     * 备用
     */
    private String beiYongYi;

    private String beiYongEr;

    private String beiYongSan;

    private String beiYongSi;

    private String beiYongWu;

    /**
     * 邮件内容
     */
    private String emailText;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSendEmailNumber() {
        return sendEmailNumber;
    }

    public void setSendEmailNumber(String sendEmailNumber) {
        this.sendEmailNumber = sendEmailNumber;
    }

    public String getRevenueEmailNumber() {
        return revenueEmailNumber;
    }

    public void setRevenueEmailNumber(String revenueEmailNumber) {
        this.revenueEmailNumber = revenueEmailNumber;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailFuJian() {
        return emailFuJian;
    }

    public void setEmailFuJian(String emailFuJian) {
        this.emailFuJian = emailFuJian;
    }

    public Date getBeiYongTime() {
        return beiYongTime;
    }

    public void setBeiYongTime(Date beiYongTime) {
        this.beiYongTime = beiYongTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeiYongYi() {
        return beiYongYi;
    }

    public void setBeiYongYi(String beiYongYi) {
        this.beiYongYi = beiYongYi;
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

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }
}