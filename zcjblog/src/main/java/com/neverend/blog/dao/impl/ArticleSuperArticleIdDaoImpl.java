package com.neverend.blog.dao.impl;

import com.neverend.blog.dao.ArticleSuperArticleIdDao;
import com.neverend.blog.entity.ArticleSuperArticleId;
import com.neverend.blog.entity.ArticleSuperArticleIdExample;
import com.neverend.blog.mapper.ArticleSuperArticleIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("ALL")
@Component
public class ArticleSuperArticleIdDaoImpl implements ArticleSuperArticleIdDao {

    @Autowired
    private ArticleSuperArticleIdMapper articleIdDao;

    /**
     * 保存文章与文章分类id
     *
     * @param ASAid
     * @return
     */
    @Override
    public int save(List<ArticleSuperArticleId> ASAid) {
        int ins = articleIdDao.save(ASAid);
        return ins;
    }

    @Override
    public int Updatesaves(List<ArticleSuperArticleId> articleSuperArticleId) {
        int ins = articleIdDao.Updatesave(articleSuperArticleId);
        return ins;
    }

    @Override
    public int delid(String articleId) {
        ArticleSuperArticleIdExample articleSuperArticleIdExample = new ArticleSuperArticleIdExample();
        ArticleSuperArticleIdExample.Criteria criteria = articleSuperArticleIdExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        int i = articleIdDao.deleteByExample(articleSuperArticleIdExample);
        return i;
    }
}