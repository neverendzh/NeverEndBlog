package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SuperArticleSort implements Serializable {
    public static final String YI_CLASS = "0";
    public static final String ER_CLASS = "1";
    public static final String SAN_CLASS = "2";
    private String num;

    private String superArticleSortId;

    /**
     * 一级分类名称
     */
    private String superArtilceName;

    /**
     * 新建用户id
     */
    private String accountId;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 更新时间
     */
    private Date toUpdate;

    /**
     * 前边是主键id值,后边表示状态
     * 1-false 删除
     * 2-true 正常
     * 3-3 锁定
     * 4-true
     * 5-true
     * 6-true
     *
     * 栏目是否可用
     * 锁定 beiYongYi 和 superArticleSortId 值一样是时锁定
     * true 正常
     * false 已删除
     */
    private String beiYongYi;

    /**
     * 父级分类id和本级。对应关系
     */
    private String beiYongEr;

    private String beiYongSan;

    private static final long serialVersionUID = 1L;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getSuperArticleSortId() {
        return superArticleSortId;
    }

    public void setSuperArticleSortId(String superArticleSortId) {
        this.superArticleSortId = superArticleSortId;
    }

    public String getSuperArtilceName() {
        return superArtilceName;
    }

    public void setSuperArtilceName(String superArtilceName) {
        this.superArtilceName = superArtilceName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getToUpdate() {
        return toUpdate;
    }

    public void setToUpdate(Date toUpdate) {
        this.toUpdate = toUpdate;
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
}