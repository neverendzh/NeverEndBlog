package com.neverend.blog.service.impl;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountExample;
import com.neverend.blog.entity.AccountLoginLog;
import com.neverend.blog.mapper.AccountLoginLogMapper;
import com.neverend.blog.mapper.AccountMapper;
import com.neverend.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;

    /**
     * 根据手机号查询用户
     * @param userMobile
     * @return
     */
    @Override
    public Account findByMobile(String userMobile) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andCellphoneNumberEqualTo(Integer.valueOf(userMobile));
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        if (accounts.size()>0){
            return accounts.get(0);
        }else {
            return null;
        }
    }

    /**
     * 保存登录日志信息
     * @param accountLoginLog
     */
    @Override
    public void saveAccountLoginLog(AccountLoginLog accountLoginLog) {
          accountLoginLogMapper.insert(accountLoginLog);
    }

    /**
     * 根据id查询用户
     * @param account
     * @return
     */
    @Override
    public Account selectAccount(Account account) {
        if (account != null || !"".equals(account.getId())){
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andIdEqualTo(account.getId());
            List<Account> accounts = accountMapper.selectByExample(accountExample);
            if (accounts.size()>0){
              return  accounts.get(0);
            }
        }
        return null;
    }

    /**
     * 根据id查询用户
     * @param account
     * @return
     */
    @Override
    public Account selectAccount(String accountId) {
        if (accountId != null || !"".equals(accountId)){
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andIdEqualTo(accountId);
            List<Account> accounts = accountMapper.selectByExample(accountExample);
            if (accounts.size()>0){
                return  accounts.get(0);
            }
        }
        return null;
    }
}
