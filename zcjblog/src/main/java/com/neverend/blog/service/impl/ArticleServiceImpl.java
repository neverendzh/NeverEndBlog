package com.neverend.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.dao.ArticleDao;
import com.neverend.blog.dao.ArticleSuperArticleIdDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.ArticleSuperArticleId;
import com.neverend.blog.entity.ArticleWithBLOBs;
import com.neverend.blog.moudel.ActicleTree;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.service.ArticleService;
import com.neverend.blog.service.mq.MsgSend;
import com.neverend.blog.util.email.FenCIUtil;
import com.neverend.blog.util.email.GetMsg;
import com.neverend.blog.util.email.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章接口实现
 *
 * @author zcj
 */
@Service
@SuppressWarnings("ALL")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private AccountServiceMyzcj accountServiceMyzcj;
    @Autowired
    private ArticleSuperArticleIdDao articleIdDao;
    @Autowired
    private MsgSend msgSend;

    public boolean getArticleName(ArticleWithBLOBs articleWithBLOBs) {
        if (articleWithBLOBs != null || !"".equals(articleWithBLOBs.getContext().trim()) || !"".equals(articleWithBLOBs.getArticleSortId().trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据文章id查询
     * 进入预览
     *
     * @param articleId
     * @return 返回的包含了大文本字段
     */
    @Override
    public ArticleWithBLOBs getArticle(String articleId) {
        List<ArticleWithBLOBs> articleWithBLOBsList = articleDao.selectArticleId(articleId);
        ArticleWithBLOBs articleWithBLOBs = null;
        if (articleWithBLOBsList.size() > 0) {
            articleWithBLOBs = articleWithBLOBsList.get(0);
        }
        int BeiYongWu = Integer.valueOf(articleWithBLOBs.getBeiYongWu())+1;
//        跟新浏览次数
        int i = articleIdDao.updateBeiWu(BeiYongWu,articleWithBLOBs.getArticleId());
        return articleWithBLOBs;
    }

    /**
     * 发布文章
     *
     * @param account
     * @param articleWithBLOBs
     * @param s                状态
     * @param acid             文章隶属分类id
     * @return msg
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Msg saveArticle(Account account, ArticleWithBLOBs articleWithBLOBs, String state, String acid, String articlelevel) {
        Msg msg = new Msg();
        Date date = new Date();
        String uuid = GetUUID.uuid();
        Account accountIsTrue = accountServiceMyzcj.selectAccount(account);
        if (accountIsTrue != null) {
            if (getArticleName(articleWithBLOBs)) {
                Article article = articleDao.selectAccountIdAndArticleName(articleWithBLOBs.getArticleName(), accountIsTrue.getId());
                if (article != null) {
//                设置文章id
                    articleWithBLOBs.setArticleId(article.getArticleId());
//                跟新时间
                    articleWithBLOBs.setBeiYongYi(Long.toString(System.currentTimeMillis()));
                    articleWithBLOBs.setState(state);
                    articleWithBLOBs.setBeiYongEr(articlelevel);
                    String code = articleDao.updateByArticle(articleWithBLOBs);

//                    取出生成的文章隶属id
                    List<String> acids = getArticeleSuperid(acid);
                    List<ArticleSuperArticleId> articleSuperArticleId = setArticleSuperid(acids, article.getArticleId());
                    int del = articleIdDao.delid(articleWithBLOBs.getArticleId());
                    int save = articleIdDao.save(articleSuperArticleId);

                    msg.setUrl("/system/admin/fabu/yulan?articleId=" + article.getArticleId());
                    msg.setCode(Code.sucess);
                    msg.setMsg(Code.sucessMsg);
                    msgSend.send(articleWithBLOBs.getArticleName());

                } else {
//                插入
                    articleWithBLOBs.setArticleId(uuid);
                    articleWithBLOBs.setAccountId(accountIsTrue.getId());
                    articleWithBLOBs.setArticleName(articleWithBLOBs.getArticleName());
                    articleWithBLOBs.setBriefIntroduction(articleWithBLOBs.getBriefIntroduction());
                    articleWithBLOBs.setCreatTime(new Date());
                    articleWithBLOBs.setArticleSortId(uuid);
                    articleWithBLOBs.setState(state);
                    articleWithBLOBs.setBeiYongEr(articlelevel);
                    articleWithBLOBs.setBeiYongWu("0");
                    int saveNum = articleDao.saveArticleDao(articleWithBLOBs);
//                    获取隶属文章的id集合
                    List<String> acidss = getArticeleSuperid(acid);
//                   设置
                    List<ArticleSuperArticleId> articleSuperArticleId = setArticleSuperid(acidss, uuid);
                    int save = articleIdDao.save(articleSuperArticleId);

                    if (saveNum > 0) {
                        msg.setUrl("/system/admin/fabu/yulan?articleId=" + articleWithBLOBs.getArticleId());
                        msg.setCode(Code.sucess);
                        msg.setMsg(Code.sucessMsg);
                        msgSend.send(articleWithBLOBs.getArticleName());
                    } else {
//                    插入失败
                        msg.setCode(Code.error);
                        msg.setCode(Code.errorMsg);

                    }

                }

            }
        } else {
            msg.setCode(Code.login);
            msg.setMsg(Code.loginMsg);
        }

        return msg;
    }

    @Override
    public PageInfo<Article> getArticleHortAsc(int pageStart, int pageNum) {
        PageInfo<Article> articles = articleDao.orderByArcileB6(pageStart, pageNum);
        return articles;

    }

    @Override
    public Msg getArticleMsg(PageInfo<Article> articleList) {
        Msg msg = new Msg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(articleList.getList());
        msg.setCount(articleList.getTotal() + "");
        msg.setCount(articleList.getPages() + "");
        return msg;
    }

    @Override
    public Msg getArtilceFeiL(String artilceid, Integer pageNum, Integer pageSize, String state,String[] artilceIds) {
        PageInfo<Article> articles = articleDao.getArtilceFeiL(artilceid, pageNum, pageSize, state,artilceIds);
        Msg msg = new Msg();
        msg.setCount(articles.getPages() + "");
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(articles.getList());
        return msg;
    }

    /**
     * @param searchname
     * @param pageStart
     * @param pageNum
     * @param state      文章状态
     * @return
     */
    @Override
    public Msg getArtilcesearch(String searchname, Integer pageStart, Integer pageNum, String state) {
        List<String> fneciLists = FenCIUtil.getFneciLists(searchname);
        PageInfo<Article> articles = articleDao.selectActilcNameLike(pageStart, pageNum, state, fneciLists);
        Msg msg = new Msg();
        msg.setCount(articles.getPages()+"");
        msg.setData(articles.getList());
        msg.setCode(Code.sucess);
        msg.setCode(Code.sucessMsg);
        return msg;
    }

    @Override
    public Msg<List<Article>> getarticlelevel(String levelNum, Integer pageStart, Integer pageNum) {
        Msg msg = new Msg();
        PageInfo<Article> articles = articleDao.getarticlelevel(levelNum, pageStart, pageNum);
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(articles.getList());
        msg.setCount(articles.getPages() + "");
        return msg;
    }

    @Override
    public Msg getArticleState(String statId, Integer pageStart, Integer pageNum) {
        Msg msg = GetMsg.getMsg();
        if (!"".equals(statId.trim())){
            PageInfo<Article> articlePageInfo = articleDao.selArticleState(statId,pageStart,pageNum);
            msg.setCode("0");
            msg.setMsg(Code.sucessMsg);
            msg.setData(articlePageInfo.getList());
            msg.setCount(articlePageInfo.getTotal()+"");
            return msg;
        }else {
            msg.setCode(Code.Paramerror);
            msg.setMsg(Code.ParamerrorMsg);
            return msg;
        }
    }

    @Override
    public Msg editState(String state, String articleID) {
        Msg msg = GetMsg.getMsg();
        int i =  articleDao.editState(state,articleID);
        if (i>0){
            msg.setCode(Code.sucess);
            msg.setMsg(Code.sucessMsg);
            return msg;
        }else {
            msg.setCode(Code.Nonexistent);
            msg.setMsg(Code.NonexistentMsg);
            return msg;
        }



    }


    /**
     * 根据文章隶属的分类id生成中间表
     *
     * @param acidss 集合当前文章隶属的文章分类id
     * @param uuid   当前文章的id
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
        getforxhhuan(acticleTrees, acaid);
        return acaid;
    }

    private void getforxhhuan(List<ActicleTree> acticleTrees, List<String> accid) {
        for (ActicleTree acticleTree : acticleTrees) {
            accid.add(acticleTree.getId());
            if (acticleTree.getChildren() != null) {
                List<ActicleTree> children = acticleTree.getChildren();
                getforxhhuan(children, accid);
            }
        }
    }

}

