package com.neverend.blog.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class ArticleWithBLOBs extends Article implements Serializable {
    /**
     * 文章内容
     */
    private String context;

    /**
     * 别用html文本内容存储
     */
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