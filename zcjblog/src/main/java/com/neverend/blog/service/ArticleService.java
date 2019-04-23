package com.neverend.blog.service;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.Msg;

/**
 * @author zcj
 */
public interface ArticleService {

    /**
     * 保存文章
     * @param account
     * @return
     */
    Msg saveArticle(Account account,ArticleWithBLOBs articleWithBLOBs);

    /**
     * 根据文章id查询
     * 进入预览
     * @param articleId
     * @return 返回的包含了大文本字段
     */
    ArticleWithBLOBs getArticle(String articleId);

    /**
     * 发布文章
     * @param account
     * @param articleWithBLOBs
     * @param s 状态
     * @return msg
     */
    Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String s);
}
