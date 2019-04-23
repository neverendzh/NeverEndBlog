package com.neverend.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.entity.SuperArticleSortExample;
import com.neverend.blog.mapper.SuperArticleSortMapper;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.SuperArticleSortService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.neverend.blog.entity.SuperArticleSort.ER_CLASS;
import static com.neverend.blog.entity.SuperArticleSort.SAN_CLASS;
import static com.neverend.blog.entity.SuperArticleSort.YI_CLASS;

/**
 * @author zcj
 */
@SuppressWarnings("ALL")
@Service
public class SuperArticleSortServiceImpl implements SuperArticleSortService {

    @Autowired
    private SuperArticleSortMapper superArticleSortMapper;
    @Autowired
    private AccountServiceImpl accountService;

    /**
     * 获取所有一级分类
     * @return 返回所有一级分类
     */
    @Override
    public PageInfo<SuperArticleSort> getSuperArticleSorts(String page,String limit,String type) {
        PageInfo<SuperArticleSort> personPageInfo = getSuperArticleSortPageInfo(page, limit,type);
        return personPageInfo;
    }

    /**
     * 二级菜单
     * @param page
     * @param limit
     * @return
     */
    @Deprecated
    private PageInfo<SuperArticleSort> getSuperArticleSortPageInfoEj(String type,String page, String limit) {
        PageHelper.startPage(Integer.valueOf(page),Integer.valueOf(limit));
        SuperArticleSortExample superArticleSortExample = new SuperArticleSortExample();
        SuperArticleSortExample.Criteria criteria = superArticleSortExample.createCriteria();
        criteria.andBeiYongYiNotLike("%false");
        criteria.andBeiYongErIsNotNull();
        List<SuperArticleSort> superArticleSortList = superArticleSortMapper.selectByExample(superArticleSortExample);
        PageInfo<SuperArticleSort> personPageInfo = new PageInfo<>(superArticleSortList);
        superArticleSortList=personPageInfo.getList();
        getfenLei(superArticleSortList,type);
        personPageInfo.setList(superArticleSortList);
        return personPageInfo;
    }

    /**
     * 一级菜单
     * @param page
     * @param limit
     * @return
     */
    private PageInfo<SuperArticleSort> getSuperArticleSortPageInfo(String page, String limit,String type) {
        PageHelper.startPage(Integer.valueOf(page),Integer.valueOf(limit));
        SuperArticleSortExample superArticleSortExample = new SuperArticleSortExample();
        SuperArticleSortExample.Criteria criteria = superArticleSortExample.createCriteria();
        criteria.andBeiYongYiNotLike("%false");
        criteria.andBeiYongErLike("%-%");
        List<SuperArticleSort> superArticleSortList = superArticleSortMapper.selectByExample(superArticleSortExample);
        PageInfo<SuperArticleSort> personPageInfo = new PageInfo<>(superArticleSortList);
        superArticleSortList = personPageInfo.getList();
        superArticleSortList = getfenLei(superArticleSortList,type);
        personPageInfo.setList(superArticleSortList);
        return personPageInfo;
    }

    /**
     * 筛选分类
     * 传入的是所有的分类 根据type返回分类
     * @param superArticleSortList
     * @return
     */
    private List<SuperArticleSort> getfenLei(List<SuperArticleSort> superArticleSortList,String type) {
        List<SuperArticleSort> lists = new ArrayList<>();
        for (SuperArticleSort superArticleSort : superArticleSortList){
            Boolean isClassType  = getSuperArticleSortTypeClass(superArticleSort.getBeiYongEr(),type);
            if (isClassType){
                    if (superArticleSort.getBeiYongYi()!=null){
                        /**
                         *解析字段BeiYongYi根据-截取，数组长度大于2，且数组中第二个值等于当前的主键值，
                         * 就把id值设置为BeiYongYI的值
                         */
                       String [] lockis =  superArticleSort.getBeiYongYi().split("-");
                       if (lockis.length>=2 && lockis[1].equals(superArticleSort.getSuperArticleSortId())){
                               superArticleSort.setBeiYongYi(superArticleSort.getSuperArticleSortId());
                       }
                    }
                      Account account = accountService.selectAccount(superArticleSort.getAccountId().toString());
                    if (account != null){
                       superArticleSort.setAccountId(account.getUserName());
                    }else {
                       superArticleSort.setAccountId("未知用户");
                    }
                    lists.add(superArticleSort);
            }else {
                continue;
            }
        }
        return lists;
    }

    private Boolean getSuperArticleSortTypeClass(String beiYongEr, String type) {
        char classType = '-';
        beiYongEr=beiYongEr.trim();
        String str2="";
        if(beiYongEr != null && !"".equals(beiYongEr)){
            for(int i=0;i<beiYongEr.length();i++){
               if (beiYongEr.charAt(i) == classType){
                  str2 = str2+classType;
               }
            }
        }
        if (str2.length() == Integer.valueOf(type)+1){
          return true;
        }
        return false;
    }

    /**
     * @param name    名称
     * @param type    类别
     * @param account 用户
     * @return
     */
    @Override
    public Msg addAtricle(String name, String type, Account account) {

        Msg msg  = new Msg();
        try {
            if (account!=null){
                if (getSuperArticleSort(name.trim())){
                    save(name, account);
                    msg.setCode("1");
                    msg.setMsg("添加成功");
                }else {
                    msg.setCode("0");
                    msg.setMsg("该分类已存在");
                }
            }else {
                msg.setCode("0");
                msg.setMsg("请先登录");
            }
        }catch (Exception e){
            msg.setCode("-1");
            msg.setMsg("服务暂停");
            e.printStackTrace();
        }
        return msg;

    }

    private void save(String name, Account account) {
        SuperArticleSort superArticleSort = new SuperArticleSort();
        Date date = new Date();
        String articleSortId = Long.toString(date.getTime());
        superArticleSort.setSuperArticleSortId(articleSortId);
        superArticleSort.setSuperArtilceName(name);
        superArticleSort.setAccountId(account.getId());
        superArticleSort.setCreatTime(new Date());
        superArticleSort.setBeiYongYi(articleSortId+"-true");
        superArticleSortMapper.insertSelective(superArticleSort);
    }

    @Override
    public Boolean getSuperArticleSort(String name){
      SuperArticleSortExample superArticleSortExample = new SuperArticleSortExample();
      SuperArticleSortExample.Criteria criteria = superArticleSortExample.createCriteria();
      criteria.andSuperArtilceNameEqualTo(name);
      List<SuperArticleSort> superArticleSorts = superArticleSortMapper.selectByExample(superArticleSortExample);
      if (superArticleSorts.size()>0){
          return false;
      }
        return true;
    }

    /**
     * 修改编辑
     *
     * @param name
     * @param type
     * @param account
     * @return
     */
    @Override
    public Msg editAtricle(String name, String type, Account account,String articleId) {

        Msg msg  = new Msg();
        try {
            if (account!=null){
                if (getSuperArticleSortarticleId(articleId.trim())){
                    update(name, account,articleId);
                    msg.setCode("1");
                    msg.setMsg("修改成功");
                }else {
                    msg.setCode("0");
                    msg.setMsg("该分类不存在");
                }
            }else {
                msg.setCode("0");
                msg.setMsg("请先登录");
            }
        }catch (Exception e){
            msg.setCode("-1");
            msg.setMsg("服务暂停");
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Msg removeAtricle(String type, Account account, String articleId) {
        Msg msg = new Msg();
        try {
           SuperArticleSort superArticleSort = superArticleSortMapper.selectByPrimaryKey(articleId);
           if (superArticleSort !=null){
               SuperArticleSort superArticleSort1 = new SuperArticleSort();
               superArticleSort1.setSuperArticleSortId(articleId);
               superArticleSort1.setBeiYongYi(articleId+"-false");
               int nums = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort1);
               msg.setMsg("已删除");
               msg.setCode("1");
           }else {
               msg.setMsg("没有此分类");
               msg.setCode("0");
           }

        }catch (Exception e){
            msg.setCode("-1");
            msg.setMsg("服务中断");
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Msg removeAtricleLock(String type, Account account, String articleId,String isLock) {
        Msg msg = new Msg();
        SuperArticleSort superArticleSort = new SuperArticleSort();
        if (YI_CLASS.equals(type)){
            String [] articleIdAndLock = articleId.split("-");
          if (articleIdAndLock.length==1 && isLock.equals("false")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-true");
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("1");
              msg.setMsg("已解除锁定");
          }else if (articleIdAndLock.length==1 && isLock.equals("true")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+articleIdAndLock[0]);
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("1");
              msg.setMsg("已锁定");
          }else if (articleIdAndLock.length==2 && isLock.equals("true")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+articleIdAndLock[0]);
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("1");
              msg.setMsg("已锁定");
          }else if (articleIdAndLock.length==2 && isLock.equals("false")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+"true");
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("1");
              msg.setMsg("已解除锁定");
          }
        }
        return msg;
    }

    /**
     * 获取分类的种类
     * 有几类分类
     *
     * @return
     */
    @Override
    public Msg getClassType() {
        SuperArticleSortExample superArticleSortExample = new SuperArticleSortExample();
        SuperArticleSortExample.Criteria criteria = superArticleSortExample.createCriteria();
        criteria.andBeiYongErIsNotNull();
        List<SuperArticleSort> superArticleSorts = superArticleSortMapper.selectByExample(superArticleSortExample);
        int jiji = getJiJiCaiDan(superArticleSorts);
        Msg msg = new Msg();
        if (jiji>0) {
            msg.setCode("0");
            msg.setCount(jiji+"");
            msg.setMsg("正常");
        }else {
            msg.setCode("1");
            msg.setCount(jiji+"");
            msg.setMsg("无数据");
        }
        return msg;
    }

    /**
     * 计算有几级菜单
     * @param superArticleSorts
     * @return
     */
    private int getJiJiCaiDan(List<SuperArticleSort> superArticleSorts) {
        Set<Integer> numType = new HashSet<Integer>();
        char classType = '-';
        for (SuperArticleSort superArticleSort : superArticleSorts){
            String classTypeTreeNumber = superArticleSort.getBeiYongEr().trim();
            String str2="";
            for(int i=0;i<classTypeTreeNumber.length();i++){
                if (classTypeTreeNumber.charAt(i) == classType){
                    str2 = str2+classType;
                }
            }
            if (str2.length()!=0){
                numType.add(str2.length());
            }
        }
        return numType.size();
    }

    private boolean getSuperArticleSortarticleId(String trim) {

        SuperArticleSortExample superArticleSortExample = new SuperArticleSortExample();
        SuperArticleSortExample.Criteria criteria = superArticleSortExample.createCriteria();
        criteria.andSuperArticleSortIdEqualTo(trim);
        List<SuperArticleSort> superArticleSorts = superArticleSortMapper.selectByExample(superArticleSortExample);
        if (superArticleSorts.size()>0){
            return true;
        }
        return false;
    }

    private void update(String name, Account account,String articleId) {
        SuperArticleSort superArticleSort = new SuperArticleSort();
        superArticleSort.setSuperArticleSortId(articleId);
        superArticleSort.setToUpdate(new Date());
        superArticleSort.setAccountId(account.getId());
        superArticleSort.setSuperArtilceName(name);
        superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
    }
}
