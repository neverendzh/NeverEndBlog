package com.neverend.blog.mapper;

import com.neverend.blog.entity.AdminEmail;
import com.neverend.blog.entity.AdminEmailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminEmailMapper {
    long countByExample(AdminEmailExample example);

    int deleteByExample(AdminEmailExample example);

    int deleteByPrimaryKey(String id);

    int insert(AdminEmail record);

    int insertSelective(AdminEmail record);

    List<AdminEmail> selectByExample(AdminEmailExample example);

    AdminEmail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AdminEmail record, @Param("example") AdminEmailExample example);

    int updateByExample(@Param("record") AdminEmail record, @Param("example") AdminEmailExample example);

    int updateByPrimaryKeySelective(AdminEmail record);

    int updateByPrimaryKey(AdminEmail record);
}