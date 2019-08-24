package com.neverend.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 
 */
@ApiModel(value="文章内容", description="文章内容html类继承自Article")
public class ArticleWithBLOBs extends Article implements Serializable {
    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容html格式")
    private String context;

    /**
     * 别用html文本内容存储
     */
    @JsonIgnore
    private String beiYongLiu;

    private static final long serialVersionUID = 1L;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getBeiYongLiu() {
        return beiYongLiu;
    }

    public void setBeiYongLiu(String beiYongLiu) {
        this.beiYongLiu = beiYongLiu;
    }
}