package com.neverend.blog.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.entity.*;
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
    public Article selectAccountIdAndArticleName(String articleName, String id) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleNameEqualTo(articleName);
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
        articleMapper.updateByPrimaryKeySelective(articleWithBLOBs);
        return articleWithBLOBs.getArticleId();
    }

    @Override
    public  PageInfo<Article>  orderByArcileB6(int pageStart, int pageNum) {
        PageHelper.startPage(pageStart,pageNum);
        ArticleExample articleExample = new ArticleExample();
        articleExample.setOrderByClause(" CAST( bei_yong_wu as signed) ASC");
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andStateEqualTo("0");
        List<Article> articles = articleMapper.selectByExample(articleExample);
        PageInfo<Article> personPageInfo = new PageInfo<>(articles);
        return personPageInfo;
    }

    @Override
    public PageInfo<Article> getArtilceFeiL(String artilceid, Integer pageStart, Integer pageSize,String state) {
        PageHelper.startPage(pageStart,pageSize);
        List<Article> articles = articleMapper.getArtilceFeiL(artilceid,state);
        PageInfo<Article> personPageInfo = new PageInfo<>(articles);
        return personPageInfo;
    }

    @Override
    public List<Article> getAll() {
        ArticleExample articleExample = new ArticleExample();
        List<Article> articles = articleMapper.selectByExample(articleExample);
        return articles;
    }

    @Override
    public PageInfo<Article> getarticlelevel(String levelNum, Integer pageStart, Integer pageNum) {
        PageHelper.startPage(pageStart,pageNum);
        ArticleExample articleExample = new ArticleExample();
        if (levelNum.equals("0")|| levelNum.equals("1")||levelNum.equals("2")
                ||levelNum.equals("3")||levelNum.equals("4")){
            articleExample.setOrderByClause(" CAST( bei_yong_wu as signed) DESC");
            ArticleExample.Criteria criteria = articleExample.createCriteria();
            criteria.andStateEqualTo("0");
            criteria.andBeiYongErEqualTo(levelNum);
        }else{
            articleExample.setOrderByClause(" CAST( bei_yong_er as signed) DESC,CAST( bei_yong_wu as signed) DESC");
            ArticleExample.Criteria criteria = articleExample.createCriteria();
            criteria.andStateEqualTo("0");
        }
        List<Article> articles = articleMapper.selectByExample(articleExample);
        PageInfo<Article> personPageInfo = new PageInfo<>(articles);
        return personPageInfo;


    }

    /**
     * 搜索文章
     * @param pageStart
     * @param pageNum
     * @param state 文章状态
     * @param fneciLists 分词后的集合
     * @return
     */
    @Override
    public PageInfo<Article> selectActilcNameLike(Integer pageStart, Integer pageNum, String state, List<String> fneciLists) {
        PageHelper.startPage(pageStart,pageNum);
        List<Article> articles = articleMapper.selectActilcNameLike(fneciLists,state);
        PageInfo<Article> personPageInfo = new PageInfo<>(articles);
        return personPageInfo;
    }

    @Override
    public PageInfo<Article> selArticleState(String statId, Integer pageStart, Integer pageNum) {
        PageHelper.startPage(pageStart,pageNum);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andStateEqualTo(statId);
        List<Article> articles = articleMapper.selectByExample(articleExample);
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return articlePageInfo;
    }

    @Override
    public int editState(String state, String articleID) {
        ArticleWithBLOBs article = new ArticleWithBLOBs();
        article.setState(state);
        ArticleExample articleExample  = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andArticleIdEqualTo(articleID);
        int i = articleMapper.updateByExampleSelective(article, articleExample);
        return i;
    }
}
