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

    /**
     * 此方法废除 推荐使用 getLanMu
     * @param accountId
     * @param names
     * @return
     */
    @Deprecated
    List<LanMuUi> getsuperLanMuGetLan(@Param("accountId")String accountId,@Param("names")String names);

    /**
     *
     * @param accountId 用户 id
     * @param names 栏目名称
     * @param state 栏目状态
     * @return
     */
    List<LanMuUi> getLanMu(@Param("accountId")String accountId,@Param("names")String names,@Param("state") String state );
}