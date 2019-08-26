package com.neverend.blog.dao;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleWithBLOBs;

import java.util.List;

/**
 * 文章dao层
 * @author zcj
 */
public interface ArticleDao {
    /**
     *保存文章信息
     * @param article
     * @return
     */
    int saveArticleDao ( ArticleWithBLOBs article);

    /**
     * 根据文章id查询
     * @param articleId
     * @return 带有长文本字段
     */
    List<ArticleWithBLOBs> selectArticleId(String articleId);

    Article selectAccountIdAndArticleName(String articleName, String id);

    /**
     * 根据文章id跟新文章
     * @param articleWithBLOBs
     * @return
     */
    String updateByArticle(ArticleWithBLOBs articleWithBLOBs);

    /**
     * 排序热度
     * @param pageStart
     * @param pageNum
     * @return
     */
    PageInfo<Article> orderByArcileB6(int pageStart, int pageNum);

    PageInfo<Article> getArtilceFeiL(String artilceid, Integer pageNum, Integer pageSize,String state);

    List<Article> getAll();

    PageInfo<Article> getarticlelevel(String levelNum, Integer pageStart, Integer pageNum);
}
