package com.neverend.blog.service;

import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.moudel.Msg;

import java.util.List;

/**
 * 文章分类
 * @author zcj
 */
public interface SuperArticleSortService {
    /**
     * 根据type获取分类的所有信息
     * 例如 type=0是一级分类
     * type=1 是二级分类
     * @return
     */
    PageInfo<SuperArticleSort> getSuperArticleSorts(String page,String limit,String type);

    /**
     *
     * @param name 名称
     * @param type 类别
     * @param account 用户
     * @return
     */
    Msg addAtricle(String name, String type, Account account);

    /**
     * 根据名称查询该分类是否存在
     * @param name
     * @return
     */
    Boolean getSuperArticleSort(String name);

    /**
     * 修改编辑
     * @param name
     * @param type
     * @param account
     * @param articleId 文章id
     * @return
     */
    Msg editAtricle(String name, String type, Account account,String articleId);

    /**
     * 根据分类 和 分类id删除
     * @param type 属于几级分类
     * @param account
     * @param articleId
     * @return
     */
    Msg removeAtricle(String type, Account account, String articleId);

    /**
     * 锁定
     * @param type
     * @param account
     * @param articleId
     * @return
     */
    Msg removeAtricleLock(String type, Account account, String articleId,String isLock);

    /**
     * 获取分类的种类
     * 有几类分类
     * @return
     */
    Msg getClassType();

}
