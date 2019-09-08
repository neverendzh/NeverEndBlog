package com.neverend.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@ApiModel(value="文章信息", description="返回文章的信息数据")
public class Article implements Serializable {
    /**
     * 文章唯一标示id
     */
    @ApiModelProperty(value="文章唯一标示id")
    private String articleId;

    /**
     * 发表用户id
     */
    @ApiModelProperty(value="发表用户id")
    private String accountId;

    /**
     * 文章标题
     */
    @ApiModelProperty(value="文章标题")
    private String articleName;

    /**
     * 文章摘要
     */
    @ApiModelProperty(value="文章摘要")
    private String briefIntroduction;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date creatTime;

    /**
     * 二级分类id
     */
    @ApiModelProperty(value="文章id用于关联文章隶属文章分类使用")
    private String articleSortId;

    /**
     * 是否禁用可看,文章状态
     * -1编辑状态
     * 0已发布，可用
     * 1禁止普通用户查看
     * 2删除
     */
    @ApiModelProperty(value="是否禁用可看,文章状态;" +
            "-1编辑状态;" +
            "0已发布，可用;" +
            "3待审核"+
            "1禁止普通用户查看;" +
            "2删除")
    private String state;

    /**
     * 文章最后跟新时间 为时间戳
     */
    @ApiModelProperty(value="文章最后跟新时间 为时间戳")
    private String beiYongYi;

    /**
     * 文章级别 0,1，3,4 以此类推0表示最低级别
     */
    @ApiModelProperty(value="文章级别 0,1,3,4 以此类推0表示最低级别")
    private String beiYongEr;
    @JsonIgnore
    private String beiYongSi;
    /**
     * 文章浏览次数
     */
    @ApiModelProperty(value="文章浏览次数")
    private String beiYongWu;
    @JsonIgnore
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