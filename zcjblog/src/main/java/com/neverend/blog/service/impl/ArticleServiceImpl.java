package com.neverend.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.dao.ArticleSuperArticleIdDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleSuperArticleId;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.mapper.AccountMapper;
import com.neverend.blog.moudel.ActicleTree;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.ArticleService;
import com.neverend.blog.util.email.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    private ArticleSuperArticleIdDao articleIdDao;
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
            Article article = articleDao.selectAccountIdAndArticleName(articleWithBLOBs.getArticleName(),accountIsTrue.getId());
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
     * @param acid 文章隶属分类id
     * @return msg
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String state,String acid)  {
        Msg msg = new Msg();
        Date date = new Date();
        String uuid = GetUUID.uuid();
        Account accountIsTrue =  accountService.selectAccount(account);
        if (accountIsTrue != null){
            if (getArticleName(articleWithBLOBs)){
                Article article = articleDao.selectAccountIdAndArticleName(articleWithBLOBs.getArticleName(),accountIsTrue.getId());
                if (article !=null ){
//                设置文章id
                    articleWithBLOBs.setArticleId(article.getArticleId());
//                跟新时间
                    articleWithBLOBs.setBeiYongYi(Long.toString(System.currentTimeMillis()));
                    String code =  articleDao.updateByArticle(articleWithBLOBs);

//                    取出生成的文章隶属id
                    List<String> acids =  getArticeleSuperid(acid);
                    List<ArticleSuperArticleId> articleSuperArticleId = setArticleSuperid(acids,article.getArticleId());
                    int  del = articleIdDao.delid(articleWithBLOBs.getArticleId());
                    int save = articleIdDao.save(articleSuperArticleId);

                    msg.setUrl("/system/admin/fabu/yulan?articleId="+article.getArticleId());
                    msg.setCode(Code.sucess);
                    msg.setMsg(Code.sucessMsg);
                }else {
//                插入
                    articleWithBLOBs.setArticleId(uuid);
                    articleWithBLOBs.setAccountId(accountIsTrue.getId());
                    articleWithBLOBs.setArticleName(articleWithBLOBs.getArticleName());
                    articleWithBLOBs.setBriefIntroduction(articleWithBLOBs.getBriefIntroduction());
                    articleWithBLOBs.setCreatTime(new Date());
                    articleWithBLOBs.setArticleSortId(uuid);
                    articleWithBLOBs.setState(state);
                    int saveNum = articleDao.saveArticleDao(articleWithBLOBs);
//                    获取隶属文章的id集合
                    List<String> acidss =  getArticeleSuperid(acid);
//                   设置
                    List<ArticleSuperArticleId> articleSuperArticleId = setArticleSuperid(acidss,uuid);
                    int save = articleIdDao.save(articleSuperArticleId);

                    if (saveNum>0){
                        msg.setUrl("/system/admin/fabu/yulan?articleId="+articleWithBLOBs.getArticleId());
                        msg.setCode(Code.sucess);
                        msg.setMsg(Code.sucessMsg);
                    }else {
//                    插入失败
                        msg.setCode("0");
                    }

                }

            }
        }else {
            msg.setCode(Code.login);
            msg.setMsg(Code.loginMsg);
        }

        return msg;
    }

    /**
     * 根据文章隶属的分类id生成中间表
     *
     * @param acidss 集合当前文章隶属的文章分类id
     * @param uuid 当前文章的id
     * @return
     */
    private List<ArticleSuperArticleId> setArticleSuperid(List<String> acidss, String uuid) {
        List<ArticleSuperArticleId> articleSuperArticleIds = new ArrayList<>();
        for (String s : acidss) {
            ArticleSuperArticleId articleSuperArticleId = new ArticleSuperArticleId();
            articleSuperArticleId.setId(GetUUID.uuid());
            articleSuperArticleId.setSuperArticleId(s);
            articleSuperArticleId.setArticleId(uuid);
            articleSuperArticleIds.add(articleSuperArticleId);
        }
        return articleSuperArticleIds;
    }

    private List<String> getArticeleSuperid(String acid) {
        JSONArray objects = JSON.parseArray(acid);
        List<ActicleTree> acticleTrees = objects.toJavaList(ActicleTree.class);
        List<String> acaid = new ArrayList<>();
        getforxhhuan(acticleTrees,acaid);
        return acaid;
    }

    private void getforxhhuan(List<ActicleTree> acticleTrees,List<String> accid) {
        for (ActicleTree acticleTree : acticleTrees) {
            accid.add(acticleTree.getId());
            if (acticleTree.getChildren()!=null){
                List<ActicleTree> children = acticleTree.getChildren();
                getforxhhuan(children,accid);
            }
        }
    }

}

