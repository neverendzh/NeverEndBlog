package com.neverend.blog.mapper;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface AccountMapper {
    public long countByExample(AccountExample example);

    public int deleteByExample(AccountExample example);

    public int deleteByPrimaryKey(String id);

    public int insert(Account record);

    public int insertSelective(Account record);

    public List<Account> selectByExample(AccountExample example);

    public Account selectByPrimaryKey(String id);

    public int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    public int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    public int updateByPrimaryKeySelective(Account record);

    public int updateByPrimaryKey(Account record);
}