package com.neverend.blog.mapper;

import com.neverend.blog.entity.QiNiuKey;
import com.neverend.blog.entity.QiNiuKeyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface QiNiuKeyMapper {
    long countByExample(QiNiuKeyExample example);

    int deleteByExample(QiNiuKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QiNiuKey record);

    int insertSelective(QiNiuKey record);

    List<QiNiuKey> selectByExample(QiNiuKeyExample example);

    QiNiuKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QiNiuKey record, @Param("example") QiNiuKeyExample example);

    int updateByExample(@Param("record") QiNiuKey record, @Param("example") QiNiuKeyExample example);

    int updateByPrimaryKeySelective(QiNiuKey record);

    int updateByPrimaryKey(QiNiuKey record);
}