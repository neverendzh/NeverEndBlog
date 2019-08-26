package com.neverend.blog.service.impl;

import com.neverend.blog.dao.SuperLanMuDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.mapper.SuperLanMuMapper;
import com.neverend.blog.moudel.LanMuUi;
import com.neverend.blog.service.SuperLanMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zcj
 */
@Service
public class SuperLanMuServiceImpl implements SuperLanMuService {

    @Autowired
    private SuperLanMuDao superLanMuDao;
    /**
     * 获取首页栏目信息
     *
     * @param LanMuName 例如传入‘首页头部’
     * @return
     */
    @Override
    public List<LanMuUi> getLanMus(Account account, String LanMuName,String state) {
        if (account!=null && account.getId()!=null && !"".equals(account.getId())){
            return superLanMuDao.getLanMus(account.getId(),LanMuName,state);
        }else {
            return superLanMuDao.getLanMus("1",LanMuName,state);
        }
    }



}
