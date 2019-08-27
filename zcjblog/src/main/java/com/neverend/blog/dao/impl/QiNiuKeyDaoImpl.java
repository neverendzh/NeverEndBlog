package com.neverend.blog.dao.impl;

import com.neverend.blog.dao.QiNiuKeyDao;
import com.neverend.blog.entity.QiNiuKey;
import com.neverend.blog.entity.QiNiuKeyExample;
import com.neverend.blog.mapper.QiNiuKeyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("ALL")
@Service
public class QiNiuKeyDaoImpl implements QiNiuKeyDao {

    @Autowired
    private QiNiuKeyMapper qiNiuKeyMapper;
    /**
     * 获取七牛as sk
     * @return
     */
    @Override
    public List<QiNiuKey> getQiNiuKey() {
        QiNiuKeyExample qiNiuKeyExample = new QiNiuKeyExample();
        List<QiNiuKey> qiNiuKeys = qiNiuKeyMapper.selectByExample(qiNiuKeyExample);
        return qiNiuKeys;
    }
}
