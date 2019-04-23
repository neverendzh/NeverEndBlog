package com.neverend.blog.dao;

import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.LanMuUi;

import java.util.List;

public interface SuperLanMuDao {
    /**
     * 获取首页栏目信息
     *
     * @param LanMuName 例如传入‘首页头部’
     * @return
     */
    List<LanMuUi> getLanMus(String accountId,String LanMuName);
}
