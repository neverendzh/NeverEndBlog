package com.neverend.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.SuperArticleSort;
import com.neverend.blog.entity.SuperArticleSortExample;
import com.neverend.blog.mapper.SuperArticleSortMapper;
import com.neverend.blog.moudel.ActicleTree;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.NumSize;
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
        PageHelper.startPage(Integer.valueOf(page),Integer.valueOf(1000));
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
                    save(name,type, account);
                    msg.setCode("200");
                    msg.setMsg("添加成功");
                }else {
                    msg.setCode("407");
                    msg.setMsg("该分类已存在");
                }
            }else {
                msg.setCode("301");
                msg.setMsg("请先登录");
            }
        }catch (Exception e){
            msg.setCode("500");
            msg.setMsg("服务暂停");
            e.printStackTrace();
        }
        return msg;

    }

    private void save(String name,String type, Account account) {

        SuperArticleSort superArticleSort = new SuperArticleSort();
        Date date = new Date();
        String articleSortId = Long.toString(date.getTime());
        superArticleSort.setSuperArticleSortId(articleSortId);
        superArticleSort.setSuperArtilceName(name);
        superArticleSort.setAccountId(account.getId());
        superArticleSort.setCreatTime(date);
        superArticleSort.setToUpdate(date);
        if ("".equals(type)){
            superArticleSort.setBeiYongSan(articleSortId);
            superArticleSort.setBeiYongEr(articleSortId+"-");
        }else {
            String[] ks = type.split("k");
            superArticleSort.setBeiYongSan(ks[0]);
            superArticleSort.setBeiYongEr(ks[1]+ks[0]+"-");
        }
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
    public Msg editAtricle(String name, Account account,String articleId) {

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
    public Msg removeAtricle(Account account, String articleId) {
        Msg msg = new Msg();
        try {
           SuperArticleSort superArticleSort = superArticleSortMapper.selectByPrimaryKey(articleId);
           if (superArticleSort !=null){
               SuperArticleSort superArticleSort1 = new SuperArticleSort();
               superArticleSort1.setSuperArticleSortId(articleId);
               superArticleSort1.setBeiYongYi(articleId+"-false");
               int nums = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort1);
               msg.setMsg("已删除");
               msg.setCode("200");
           }else {
               msg.setMsg("没有此分类");
               msg.setCode("404");
           }

        }catch (Exception e){
            msg.setCode("500");
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
              msg.setCode("200");
              msg.setMsg("已解除锁定");
          }else if (articleIdAndLock.length==1 && isLock.equals("true")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+articleIdAndLock[0]);
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("200");
              msg.setMsg("已锁定");
          }else if (articleIdAndLock.length==2 && isLock.equals("true")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+articleIdAndLock[0]);
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("200");
              msg.setMsg("已锁定");
          }else if (articleIdAndLock.length==2 && isLock.equals("false")){
              superArticleSort.setSuperArticleSortId(articleIdAndLock[0]);
              superArticleSort.setBeiYongYi(articleIdAndLock[0]+"-"+"true");
              int updateNmuber = superArticleSortMapper.updateByPrimaryKeySelective(superArticleSort);
              msg.setCode("200");
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
            msg.setData(new NumSize(jiji));
            msg.setMsg("正常");
        }else {
            msg.setCode("1");
            msg.setCount(jiji+"");
            msg.setData(new NumSize(jiji));
            msg.setMsg("无数据");
        }
        return msg;
    }

    /**
     *
     * 获取所有分类和分类名称
     * @return
     */
    @Override
    public Msg getClassTypeNameS(boolean checked) {
        Msg msg = new Msg();
        List<SuperArticleSort> articles = superArticleSortMapper.selArticleNameSTypeS();
        Map<String,List<SuperArticleSort>> treeMap = new HashMap<>();
        getTreeMap(articles, treeMap);
        int size = treeMap.size();
        List<ActicleTree> retunActicleTree = new ArrayList<>();
//        设置一级节点
        getNoeTree(treeMap, size, retunActicleTree);
//        List<ActicleTree> addTreead = null;
//      设置二级节点
            HashSet<String> parene = new HashSet<>();
            List<SuperArticleSort> treeXiaJi = treeMap.get(Integer.toString(2));
            for (int k=0;k<treeXiaJi.size();k++) {
                for (int j =0;j<retunActicleTree.size();j++) {
//                       获取 retunActicleTree 第几层的第几个节点
                    ActicleTree acticleTree = null;
                    SuperArticleSort superArticleSort = treeXiaJi.get(k);
                    String beiYongSan = superArticleSort.getBeiYongSan();
                    acticleTree = retunActicleTree.get(j);
                    if (acticleTree.getId().equals(beiYongSan)){
                        addTree(retunActicleTree,superArticleSort,j);
                        parene.add(Integer.toString(j));
                    }
                }
            }
//设置三级节点
        List<SuperArticleSort> treeXiaJisan = treeMap.get(Integer.toString(3));
        HashSet<String> pareneSan = new HashSet<>();
        for (int i=0;i<treeXiaJisan.size();i++) {
            SuperArticleSort superArticleSort = treeXiaJisan.get(i);
            String beiYongSan = superArticleSort.getBeiYongSan();
            for (String s : parene) {
                List<ActicleTree> acticleTrees = retunActicleTree.get(Integer.valueOf(s)).getChildren();
               for (int k=0;k<acticleTrees.size();k++){
                   ActicleTree acticleTree = acticleTrees.get(k);
                   if (acticleTrees.get(k).getId().equals(beiYongSan)){
                       pareneSan.add(Integer.toString(k));
                       if (acticleTree.getChildren()!=null){
                           List<ActicleTree> children = acticleTree.getChildren();
                           ActicleTree acticleTreeadd = new ActicleTree();
                           acticleTreeadd.setTitle(superArticleSort.getSuperArtilceName());
                           acticleTreeadd.setId(superArticleSort.getSuperArticleSortId());
                           acticleTreeadd.setChecked(false);
                           acticleTreeadd.setDisabled(false);
                           children.add(acticleTreeadd);
                           acticleTree.setChildren(children);
                       }else {
                           List<ActicleTree> children = new ArrayList<>();
                           ActicleTree acticleTreeadd = new ActicleTree();
                           acticleTreeadd.setTitle(superArticleSort.getSuperArtilceName());
                           acticleTreeadd.setId(superArticleSort.getSuperArticleSortId());
                           acticleTreeadd.setChecked(false);
                           acticleTreeadd.setDisabled(false);
                           children.add(acticleTreeadd);
                           acticleTree.setChildren(children);
                       }
                   }
               }

            }
        }
//设置四级级节点
        List<SuperArticleSort> treeXiaJiSi = treeMap.get(Integer.toString(4));

        for (int i=0;i<treeXiaJiSi.size();i++) {
            SuperArticleSort superArticleSort = treeXiaJiSi.get(i);
            String beiYongSan = superArticleSort.getBeiYongSan();
            for (String s : parene) {
                List<ActicleTree> acticleTrees = retunActicleTree.get(Integer.valueOf(s)).getChildren();
                for (int k=0;k<acticleTrees.size();k++){
                    if (acticleTrees.get(k).getChildren()!=null){
                        List<ActicleTree> acticleTree11 = acticleTrees.get(k).getChildren();
                        for (String s1 : pareneSan) {
                            ActicleTree acticleTree = acticleTree11.get(Integer.valueOf(s1));
                            if (acticleTree.getId().equals(beiYongSan)){
                                if (acticleTree.getChildren()!=null){
                                    List<ActicleTree> children = acticleTree.getChildren();
                                    ActicleTree acticleTreeadd = new ActicleTree();
                                    acticleTreeadd.setTitle(superArticleSort.getSuperArtilceName());
                                    acticleTreeadd.setId(superArticleSort.getSuperArticleSortId());
                                    acticleTreeadd.setChecked(false);
                                    acticleTreeadd.setDisabled(false);
                                    children.add(acticleTreeadd);
                                    acticleTree.setChildren(children);
                                }else {
                                    List<ActicleTree> children = new ArrayList<>();
                                    ActicleTree acticleTreeadd = new ActicleTree();
                                    acticleTreeadd.setTitle(superArticleSort.getSuperArtilceName());
                                    acticleTreeadd.setId(superArticleSort.getSuperArticleSortId());
                                    acticleTreeadd.setChecked(false);
                                    acticleTreeadd.setDisabled(false);
                                    children.add(acticleTreeadd);
                                    acticleTree.setChildren(children);
                                }
                            }
                        }
                    }
                }

            }
        }

        msg.setData(retunActicleTree);
        msg.setCode("0");
        msg.setMsg("sucess");
        msg.setCount(retunActicleTree.size()+"");
        return msg;
    }

    /**
     * 获取上级分类
     * @param type
     * @return
     */
    @Override
    public Msg getType(String type) {
        List<SuperArticleSort> articles = superArticleSortMapper.selArticleNameSTypeS();
        Map<String,List<SuperArticleSort>> treeMap = new HashMap<>();
        getTreeMap(articles, treeMap);
        List<SuperArticleSort> superArticleSorts = null;
        if (type.equals("0")){
            superArticleSorts =treeMap.get(Integer.toString(1));
        }else {
            superArticleSorts = treeMap.get(Integer.toString(Integer.valueOf(type)+1));
        }
        Msg msg = new Msg();
        msg.setCode("0");
        msg.setData(superArticleSorts);
        return msg;
    }

    private void addTree3(List<ActicleTree> retunActicleTree, SuperArticleSort superArticleSort, int ch) {

    }


    private List<ActicleTree> addTree(List<ActicleTree> retunActicleTree, SuperArticleSort xiaji,int j) {
        ActicleTree acticleTree = retunActicleTree.get(j);

        List<ActicleTree> acticleEdit = null;
        if (acticleTree.getChildren()!=null){
            acticleEdit = acticleTree.getChildren();
        }else {
            acticleEdit = new ArrayList<>();
        }

        ActicleTree acticleTreeadd = new ActicleTree();
        acticleTreeadd.setTitle(xiaji.getSuperArtilceName());
        acticleTreeadd.setId(xiaji.getSuperArticleSortId());
        acticleTreeadd.setChecked(false);
        acticleTreeadd.setDisabled(false);
        acticleEdit.add(acticleTreeadd);
        acticleTree.setChildren(acticleEdit);
        retunActicleTree.set(j,acticleTree);
        return retunActicleTree;
    }

    private void getNoeTree(Map<String, List<SuperArticleSort>> treeMap, int size, List<ActicleTree> retunActicleTree) {
        //        获取第一级节点
        if (size>0){
            List<SuperArticleSort> superArticleSortList = treeMap.get(Integer.toString(1));
            for (SuperArticleSort articleSort : superArticleSortList) {
                ActicleTree acticleTree = new ActicleTree();
                acticleTree.setTitle(articleSort.getSuperArtilceName());
                acticleTree.setId(articleSort.getSuperArticleSortId());
                acticleTree.setChecked(false);
                acticleTree.setDisabled(false);
                retunActicleTree.add(acticleTree);
            }
        }
    }

    /**
     * 根据getBeiYongEr长度分类，确定属于总节点中的第几级节点
     * @param articles
     * @param treeMap
     * @return
     */
    private   void getTreeMap(List<SuperArticleSort> articles, Map<String, List<SuperArticleSort>> treeMap) {
        for (SuperArticleSort superArticleSort : articles){
            String treelength = Integer.toString(superArticleSort.getBeiYongEr().split("-").length);
            int treelengthInt = Integer.valueOf(treelength);

            if (treeMap.get(treelength) != null){
                List<SuperArticleSort> superArticleSorts = treeMap.get(treelength);
                superArticleSorts.add(superArticleSort);
            }else {
                List<SuperArticleSort> superArticleSortsTr = new ArrayList<>();
                superArticleSortsTr.add(superArticleSort);
                treeMap.put(treelength,superArticleSortsTr);
            }
        }
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
