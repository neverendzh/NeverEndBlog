package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class ArtilceRespondToMessages implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 用户id
     */
    private String accountId;

    /**
     * 回复留言id
     */
    private String respondToMessagesId;

    /**
     * 回复所属留言的回复id
     */
    private String respondToMessagesIdId;

    /**
     * 回复时间
     */
    private Date time;

    /**
     * 回复内容
     */
    private String message;

    /**
     * 对应回复图片表id
     */
    private String imgId;

    /**
     * 点赞次数
     */
    private Integer fabulousNum;

    private String beiYongYi;

    private String beiYongEr;

    private String beiYongSan;

    private String beiYongSi;

    private String beiYongWu;

    private String beiYongLiu;

    private String beiYongQi;

    private String beiYongBa;

    private Date timeBeiYi;

    private Date timeBeiEr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getRespondToMessagesId() {
        return respondToMessagesId;
    }

    public void setRespondToMessagesId(String respondToMessagesId) {
        this.respondToMessagesId = respondToMessagesId;
    }

    public String getRespondToMessagesIdId() {
        return respondToMessagesIdId;
    }

    public void setRespondToMessagesIdId(String respondToMessagesIdId) {
        this.respondToMessagesIdId = respondToMessagesIdId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public Integer getFabulousNum() {
        return fabulousNum;
    }

    public void setFabulousNum(Integer fabulousNum) {
        this.fabulousNum = fabulousNum;
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

    public Date getTimeBeiYi() {
        return timeBeiYi;
    }

    public void setTimeBeiYi(Date timeBeiYi) {
        this.timeBeiYi = timeBeiYi;
    }

    public Date getTimeBeiEr() {
        return timeBeiEr;
    }

    public void setTimeBeiEr(Date timeBeiEr) {
        this.timeBeiEr = timeBeiEr;
    }
}