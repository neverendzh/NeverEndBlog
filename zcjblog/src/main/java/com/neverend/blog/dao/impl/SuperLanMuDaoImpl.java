package com.neverend.blog.dao.impl;

import com.neverend.blog.dao.SuperLanMuDao;
import com.neverend.blog.entity.Account;
import com.neverend.blog.mapper.SuperLanMuMapper;
import com.neverend.blog.moudel.LanMuUi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zcg
 */
@SuppressWarnings("ALL")
@Service
public class SuperLanMuDaoImpl implements SuperLanMuDao {

    @Autowired
    private SuperLanMuMapper superLanMuMapper;

    /**
     * 获取首页栏目信息
     *
     * @param LanMuName 例如传入‘首页头部’
     * @return
     */
    @Override
    public List<LanMuUi> getLanMus(String accountId,String LanMuName,String state) {
        String names = LanMuName.trim();
//        List<LanMuUi> lanMuUis = superLanMuMapper.getsuperLanMuGetLan(accountId,names);
        List<LanMuUi> lanMuUis  = superLanMuMapper.getLanMu(accountId,names,state);
       return lanMuUis;
    }
}
