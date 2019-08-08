package com.neverend.blog.dao;

import com.neverend.blog.entity.ArticleSuperArticleId;

import java.util.List;

public interface ArticleSuperArticleIdDao {
    /**
     * 保存文章与文章分类id
     * @param ASAid
     * @return
     */
    int save(List<ArticleSuperArticleId> ASAid);

    /**
     * 跟新
     * @param articleSuperArticleId
     * @return
     */
    int Updatesaves(List<ArticleSuperArticleId> articleSuperArticleId);

    /**
     * 根据文章id删除对应关系
     * @param articleId
     * @return
     */
    int delid(String articleId);
}
