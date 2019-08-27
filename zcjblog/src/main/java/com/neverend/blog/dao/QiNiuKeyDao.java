package com.neverend.blog.dao;

import com.neverend.blog.entity.QiNiuKey;

import java.util.List;

public interface QiNiuKeyDao {
    /**
     * 获取七牛as sk
     * @return
     */
    List<QiNiuKey> getQiNiuKey();
}
