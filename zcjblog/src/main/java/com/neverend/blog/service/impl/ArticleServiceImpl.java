package com.neverend.blog.service.impl;

import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.mapper.AccountMapper;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 文章接口实现
 * @author zcj
 */
@Service
@SuppressWarnings("ALL")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AccountService accountService;
    /**
     * 保存文章
     * @param articleWithBLOBs
     * @return
     */
    @Override
    public Msg saveArticle(Account account,ArticleWithBLOBs articleWithBLOBs) {
        Msg msg = new Msg();
        Date date = new Date();
        Account accountIsTrue =  accountService.selectAccount(account);
        if (accountIsTrue == null){
            msg.setCode("0");
            msg.setMsg("请登录后操作");
            return msg;
        }
        if (getArticleName(articleWithBLOBs)){
            Article article = articleDao.selectAccountIdAndArticleName(articleWithBLOBs.getArticleName(),articleWithBLOBs.getArticleSortId(),accountIsTrue.getId());
            if (article !=null ){
//                设置用户id
                articleWithBLOBs.setAccountId(accountIsTrue.getId());
//                设置文章id
                articleWithBLOBs.setArticleId(article.getArticleId());
//                跟新时间
                articleWithBLOBs.setBeiYongYi(Long.toString(date.getTime()));
//                  创建时间
                articleWithBLOBs.setCreatTime(article.getCreatTime());
//                状态
                articleWithBLOBs.setState("-1");

                String code =  articleDao.updateByArticle(articleWithBLOBs);
                msg.setUrl("/system/admin/fabu/yulan?articleId="+article.getArticleId());
                msg.setCode("1");
            }else {
//                插入
                articleWithBLOBs.setArticleId(Long.toString(date.getTime()));
                articleWithBLOBs.setAccountId(accountIsTrue.getId());
                articleWithBLOBs.setArticleName(articleWithBLOBs.getArticleName());
                articleWithBLOBs.setBriefIntroduction(articleWithBLOBs.getBriefIntroduction());
                articleWithBLOBs.setCreatTime(new Date());
                articleWithBLOBs.setArticleSortId(articleWithBLOBs.getArticleSortId());
                articleWithBLOBs.setState("-1");
                int saveNum = articleDao.saveArticleDao(articleWithBLOBs);
                if (saveNum>0){
                    msg.setUrl("/system/admin/fabu/yulan?articleId="+articleWithBLOBs.getArticleId());
                    msg.setCode("1");
                }else {
//                    插入失败
                    msg.setCode("0");
                }

            }

        }

        return msg;
    }

    public boolean getArticleName(ArticleWithBLOBs articleWithBLOBs){
       if (articleWithBLOBs!=null || !"".equals(articleWithBLOBs.getContext().trim())|| !"".equals(articleWithBLOBs.getArticleSortId().trim())){
           return true;
       }else {
           return false;
       }
    }
    /**
     * 根据文章id查询
     * 进入预览
     * @param articleId
     * @return 返回的包含了大文本字段
     */
    @Override
    public ArticleWithBLOBs getArticle(String articleId) {
        List<ArticleWithBLOBs> articleWithBLOBsList = articleDao.selectArticleId(articleId);
        ArticleWithBLOBs articleWithBLOBs = null;
        if (articleWithBLOBsList.size()>0){
            articleWithBLOBs = articleWithBLOBsList.get(0);
        }
        return articleWithBLOBs;
    }

    /**
     * 发布文章
     * @param account
     * @param articleWithBLOBs
     * @param s                状态
     * @return msg
     */
    @Override
    public Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String state) {
        Msg msg = new Msg();
        Date date = new Date();
        Account accountIsTrue =  accountService.selectAccount(account);
        if (getArticleName(articleWithBLOBs)){
            Article article = articleDao.selectAccountIdAndArticleName(articleWithBLOBs.getArticleName(),articleWithBLOBs.getArticleSortId(),accountIsTrue.getId());
            if (article !=null ){
//                设置用户id
                articleWithBLOBs.setAccountId(accountIsTrue.getId());
//                设置文章id
                articleWithBLOBs.setArticleId(article.getArticleId());
//                跟新时间
                articleWithBLOBs.setBeiYongYi(Long.toString(date.getTime()));
//                  创建时间
                articleWithBLOBs.setCreatTime(article.getCreatTime());
//                状态
                articleWithBLOBs.setState(state);
                String code =  articleDao.updateByArticle(articleWithBLOBs);
                msg.setUrl("/system/admin/fabu/yulan?articleId="+article.getArticleId());
                msg.setCode("1");
            }else {
//                插入
                articleWithBLOBs.setArticleId(Long.toString(date.getTime()));
                articleWithBLOBs.setAccountId(accountIsTrue.getId());
                articleWithBLOBs.setArticleName(articleWithBLOBs.getArticleName());
                articleWithBLOBs.setBriefIntroduction(articleWithBLOBs.getBriefIntroduction());
                articleWithBLOBs.setCreatTime(new Date());
                articleWithBLOBs.setArticleSortId(articleWithBLOBs.getArticleSortId());
                articleWithBLOBs.setState(state);
                int saveNum = articleDao.saveArticleDao(articleWithBLOBs);
                if (saveNum>0){
                    msg.setUrl("/system/admin/fabu/yulan?articleId="+articleWithBLOBs.getArticleId());
                    msg.setCode("1");
                }else {
//                    插入失败
                    msg.setCode("0");
                }

            }

        }

        return msg;
    }
}

