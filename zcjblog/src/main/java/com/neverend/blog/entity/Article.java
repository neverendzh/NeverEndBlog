package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Article implements Serializable {
    private String articleId;

    /**
     * 发表用户id
     */
    private String accountId;

    /**
     * 文章标题
     */
    private String articleName;

    /**
     * 文章摘要
     */
    private String briefIntroduction;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 二级分类id
     */
    private String articleSortId;

    /**
     * 是否禁用可看,文章状态
     * -1编辑状态
     * 0已发布
     * 1禁止普通用户查看
     * 2删除
     */
    private String state;

    /**
     * 文章最后跟新时间 为时间戳
     */
    private String beiYongYi;

    private String beiYongEr;

    private String beiYongSi;

    private String beiYongWu;

    private String beiYongQi;

    private static final long serialVersionUID = 1L;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getArticleSortId() {
        return articleSortId;
    }

    public void setArticleSortId(String articleSortId) {
        this.articleSortId = articleSortId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getBeiYongQi() {
        return beiYongQi;
    }

    public void setBeiYongQi(String beiYongQi) {
        this.beiYongQi = beiYongQi;
    }
}