package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class QiNiuKey implements Serializable {
    private Integer id;

    /**
     * ak
     */
    private String ak;

    /**
     * sk
     */
    private String sk;

    /**
     * 七牛存储空间名称
     */
    private String qiNiuName;

    /**
     * 域名
     */
    private String yuMing;

    private Date ereattime;

    private Date updatetime;

    private Integer roleCode;

    private String beiYi;

    private String bieEr;

    private String bieSan;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getQiNiuName() {
        return qiNiuName;
    }

    public void setQiNiuName(String qiNiuName) {
        this.qiNiuName = qiNiuName;
    }

    public String getYuMing() {
        return yuMing;
    }

    public void setYuMing(String yuMing) {
        this.yuMing = yuMing;
    }

    public Date getEreattime() {
        return ereattime;
    }

    public void setEreattime(Date ereattime) {
        this.ereattime = ereattime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public String getBeiYi() {
        return beiYi;
    }

    public void setBeiYi(String beiYi) {
        this.beiYi = beiYi;
    }

    public String getBieEr() {
        return bieEr;
    }

    public void setBieEr(String bieEr) {
        this.bieEr = bieEr;
    }

    public String getBieSan() {
        return bieSan;
    }

    public void setBieSan(String bieSan) {
        this.bieSan = bieSan;
    }
}