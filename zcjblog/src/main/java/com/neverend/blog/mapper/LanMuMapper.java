package com.neverend.blog.mapper;

import com.neverend.blog.entity.LanMu;
import com.neverend.blog.entity.LanMuExample;
import java.util.List;

import com.neverend.blog.entity.SuperLanMu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LanMuMapper {
    long countByExample(LanMuExample example);

    int deleteByExample(LanMuExample example);

    int deleteByPrimaryKey(String yiJiLanMuId);

    int insert(LanMu record);

    int insertSelective(LanMu record);

    List<LanMu> selectByExample(LanMuExample example);

    LanMu selectByPrimaryKey(String yiJiLanMuId);

    int updateByExampleSelective(@Param("record") LanMu record, @Param("example") LanMuExample example);

    int updateByExample(@Param("record") LanMu record, @Param("example") LanMuExample example);

    int updateByPrimaryKeySelective(LanMu record);

    int updateByPrimaryKey(LanMu record);

}