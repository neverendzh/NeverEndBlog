package com.neverend.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@ApiModel(value="文章分类对象", description="文章分类对象数据集合")
public class SuperArticleSort implements Serializable {
    public static final String YI_CLASS = "0";
    public static final String ER_CLASS = "1";
    public static final String SAN_CLASS = "2";
    @JsonIgnore
    private String num;

    @ApiModelProperty(value="文章分类唯一标示id")
    private String superArticleSortId;

    /**
     * 文章分类名称
     */
    @ApiModelProperty(value="文章分类名称")
    private String superArtilceName;

    /**
     * 新曾分类用户id
     */
    @ApiModelProperty(value="新曾分类用户id")
    private String accountId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date creatTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新修改时间")
    private Date toUpdate;

    /**
     * 前边是主键superArticleSortId值,后边表示状态
     * 例如：1-false 删除
     *      2-true 栏目是否可用
     *      3-3 锁定
     *
     * 锁定是 beiYongYi 和 superArticleSortId 值一样是时锁定
     * true 正常
     * false 已删除
     */
    @ApiModelProperty(value="前边是主键superArticleSortId值,后边表示状态;" +
            "例如：1-false 删除;" +
            "     2-true 栏目是否可用;" +
            "     3-3 锁定;" +
            "锁定是 beiYongYi 和 superArticleSortId 值一样是时锁定")
    private String beiYongYi;

    /**
     * 表示当前文章分类的层级关系
     * 例如:1565172980628-1565172980628-1565173686704-
     * 使用-分割 最后一个是当前分类id，倒数第二个是上级分类id，倒数第三个是上上级分类id，依次类推
     *
     */
    @ApiModelProperty(value="表示当前文章分类的层级关系;" +
            "例如:1565172980628-1565172980628-1565173686704-;" +
            "使用-分割 最后一个是当前分类id，倒数第二个是上级分类id，倒数第三个是上上级分类id，依次类推")
    private String beiYongEr;

    /**
     *  直属上级分类id
     */
    @ApiModelProperty(value="直属上级分类id")
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