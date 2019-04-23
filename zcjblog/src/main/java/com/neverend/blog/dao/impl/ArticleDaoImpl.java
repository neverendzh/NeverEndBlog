package com.neverend.blog.dao.impl;

import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleExample;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章存储查询dao
 * @author zcj
 */
@SuppressWarnings("ALL")
@Component
public class ArticleDaoImpl implements ArticleDao {
    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 保存文章信息
     * @param article
     * @return
     */
    @Override
    public int saveArticleDao(ArticleWithBLOBs article) {
        int code = articleMapper.insert(article);
        return code;
    }

    /**
     * 根据文章id查询
     *
     * @param articleId
     * @return 带有长文本字段
     */
    @Override
    public List<ArticleWithBLOBs> selectArticleId(String articleId) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<ArticleWithBLOBs> articleWithBLOBs =  articleMapper.selectByExampleWithBLOBs(articleExample);
        return articleWithBLOBs;
    }

    /**
     * 查询当前用户是否存在改文章
     * @param articleName 文章名称
     * @param id 用户id
     * @return
     */
    @Override
    public Article selectAccountIdAndArticleName(String articleName,String sortId, String id) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleNameEqualTo(articleName);
        criteria.andArticleSortIdEqualTo(sortId);
        criteria.andAccountIdEqualTo(id);
        List<Article> articles =  articleMapper.selectByExample(articleExample);
        if (articles.size()>0){
            return articles.get(0);
        }
        return null;
    }

    /**
     * 根据文章id跟新文章
     *
     * @param articleWithBLOBs
     * @param articleId
     * @return
     */
    @Override
    public String updateByArticle(ArticleWithBLOBs articleWithBLOBs) {
        articleMapper.updateByPrimaryKeyWithBLOBs(articleWithBLOBs);
        return articleWithBLOBs.getArticleId();
    }
}
