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
    Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String s,String acid,String articlelevel);

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

    /**
     * 根据文章分类id查询下级所有的文章
     * @param artilceid
     * @param pageNum 开始页
     * @param pageSize 条数
     * @return
     */
    Msg getArtilceFeiL(String artilceid,Integer pageNum,Integer pageSize,String state,String [] articleIds);

    /**
     * 根据名称搜索 或者文章分类名称搜索
     * @param searchname
     * @param pageStart
     * @param pageNum
     * @param state
     * @return
     */
    Msg getArtilcesearch(String searchname, Integer pageStart, Integer pageNum, String state);


    /**
     * 根据传递的界别返回推荐文章
     * @param levelNum
     * @param pageStart
     * @param pageNum
     * @return
     */
    Msg<List<Article>> getarticlelevel(String levelNum, Integer pageStart, Integer pageNum);

    /**
     * 根据文章状态搜索
     * @param statId
     * @param pageStart
     * @param pageNum
     * @return
     */
    Msg getArticleState(String statId, Integer pageStart, Integer pageNum);

    /**
     * 修改文章状态
     * @param state
     * @param articleID
     * @return
     */
    Msg editState(String state, String articleID);
}
