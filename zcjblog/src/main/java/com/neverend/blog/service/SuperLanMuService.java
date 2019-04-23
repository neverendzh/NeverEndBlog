package com.neverend.blog.service;

import com.neverend.blog.entity.Account;
import com.neverend.blog.moudel.LanMuUi;

import java.util.List;
import java.util.Map;

/**
 * @author zcj
 */
public interface SuperLanMuService {

    /**
     * 获取首页栏目信息
     *
     * @param LanMuName 例如传入‘首页头部’
     * @return
     */
    List<LanMuUi> getLanMus(Account account,String LanMuName);
}
