package com.neverend.blog.dao;

import com.neverend.blog.entity.QiNiuKey;

import java.util.List;

public interface QiNiuKeyDao {
    /**
     * 获取七牛as sk
     * @param kongjian 存储的空间 0 表示默认 1表示用户头像 2表示文件
     * @return
     */
    List<QiNiuKey> getQiNiuKey(String kongjian);
}
