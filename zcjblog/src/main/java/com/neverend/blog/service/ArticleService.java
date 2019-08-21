package com.neverend.blog.service;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.Msg;

import java.util.List;

/**
 * @author zcj
 */
public interface ArticleService {
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
    Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String s,String acid);

    /**
     * 根据热度排序文章
     * @param pageStart
     * @param pageNum
     * @return
     */
    PageInfo<Article> getArticleHortAsc(int pageStart, int pageNum );

    /**
     * 把查询出的文章封装为msg对象
     * @param articleList
     * @return
     */
    Msg getArticleMsg(PageInfo<Article> articleList);
}
