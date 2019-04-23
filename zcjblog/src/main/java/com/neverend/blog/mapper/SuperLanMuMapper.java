package com.neverend.blog.mapper;

import com.neverend.blog.entity.SuperLanMu;
import com.neverend.blog.entity.SuperLanMuExample;
import java.util.List;
import java.util.Map;

import com.neverend.blog.moudel.LanMuUi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SuperLanMuMapper {
    long countByExample(SuperLanMuExample example);

    int deleteByExample(SuperLanMuExample example);

    int deleteByPrimaryKey(String superLanMuId);

    int insert(SuperLanMu record);

    int insertSelective(SuperLanMu record);

    List<SuperLanMu> selectByExample(SuperLanMuExample example);

    SuperLanMu selectByPrimaryKey(String superLanMuId);

    int updateByExampleSelective(@Param("record") SuperLanMu record, @Param("example") SuperLanMuExample example);

    int updateByExample(@Param("record") SuperLanMu record, @Param("example") SuperLanMuExample example);

    int updateByPrimaryKeySelective(SuperLanMu record);

    int updateByPrimaryKey(SuperLanMu record);

    List<LanMuUi> getsuperLanMuGetLan(@Param("accountId")String accountId,@Param("names")String names);
}