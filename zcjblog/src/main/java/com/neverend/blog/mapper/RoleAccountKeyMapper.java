package com.neverend.blog.mapper;

import com.neverend.blog.entity.RoleAccountKey;
import com.neverend.blog.entity.RoleAccountKeyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleAccountKeyMapper {
    long countByExample(RoleAccountKeyExample example);

    int deleteByExample(RoleAccountKeyExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleAccountKey record);

    int insertSelective(RoleAccountKey record);

    List<RoleAccountKey> selectByExample(RoleAccountKeyExample example);

    RoleAccountKey selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleAccountKey record, @Param("example") RoleAccountKeyExample example);

    int updateByExample(@Param("record") RoleAccountKey record, @Param("example") RoleAccountKeyExample example);

    int updateByPrimaryKeySelective(RoleAccountKey record);

    int updateByPrimaryKey(RoleAccountKey record);
}