package com.neverend.blog.mapper;

import com.neverend.blog.entity.RolesPermissionKey;
import com.neverend.blog.entity.RolesPermissionKeyExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RolesPermissionKeyMapper {
    long countByExample(RolesPermissionKeyExample example);

    int deleteByExample(RolesPermissionKeyExample example);

    int deleteByPrimaryKey(String id);

    int insert(RolesPermissionKey record);

    int insertSelective(RolesPermissionKey record);

    List<RolesPermissionKey> selectByExample(RolesPermissionKeyExample example);

    RolesPermissionKey selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionKeyExample example);

    int updateByExample(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionKeyExample example);

    int updateByPrimaryKeySelective(RolesPermissionKey record);

    int updateByPrimaryKey(RolesPermissionKey record);
}