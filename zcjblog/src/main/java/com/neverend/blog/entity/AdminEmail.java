package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class AdminEmail implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 发件人
     */
    private String email;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 口令
     */
    private String passwordKoLing;

    /**
     * 类型
     */
    private String type;

    /**
     * 端口
     */
    private Integer host;

    /**
     * 发件人名称
     */
    private String name;

    /**
     * 最后y一次发送时间
     */
    private Date sendEndTime;

    private String beiYongYi;

    private String beiYongEr;

    private String beiYongSan;

    private String beiYongSi;

    private String beiYongWu;

    private static final long serialVersionUID = 1L;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getPasswordKoLing() {
        return passwordKoLing;
    }

    public void setPasswordKoLing(String passwordKoLing) {
        this.passwordKoLing = passwordKoLing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHost() {
        return host;
    }

    public void setHost(Integer host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSendEndTime() {
        return sendEndTime;
    }

    public void setSendEndTime(Date sendEndTime) {
        this.sendEndTime = sendEndTime;
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
}