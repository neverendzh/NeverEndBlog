package com.neverend.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountExample;
import com.neverend.blog.entity.AccountLoginLog;
import com.neverend.blog.entity.RoleAccountKey;
import com.neverend.blog.mapper.AccountLoginLogMapper;
import com.neverend.blog.mapper.AccountMapper;
import com.neverend.blog.mapper.RoleAccountKeyMapper;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.util.email.GetMsg;
import com.neverend.blog.util.email.GetUUID;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AccountServiceMyzcjImpl implements AccountServiceMyzcj {

    @Autowired
    public AccountMapper accountMapper;
    @Autowired
    public RoleAccountKeyMapper roleAccountKeyMapper;
    @Autowired
    public AccountLoginLogMapper accountLoginLogMapper;

    /**
     * 根据手机号查询用户
     *
     * @param userMobile
     * @return
     */
    @Override
    public Account findByMobile(String userMobile) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andCellphoneNumberEqualTo(userMobile);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        if (accounts.size() > 0) {
            return accounts.get(0);
        } else {
            return null;
        }
    }

    /**
     * 保存登录日志信息
     *
     * @param accountLoginLog
     */
    @Override
    public void saveAccountLoginLog(AccountLoginLog accountLoginLog) {
        accountLoginLogMapper.insert(accountLoginLog);
    }

    /**
     * 账号注册
     *
     * @param userName
     * @param accountNumber
     * @param password
     * @param isEncryption
     * @return
     */
    @Override
    @Transactional
    public Msg registeredAccount(String userName, String accountNumber,
                                 String password, String isEncryption,
                                 String email) {
        boolean account1 = isAccount(accountNumber);
        Msg msg = new Msg();
        if (account1) {
            msg.setMsg(Code.repeatMsg);
            msg.setCode(Code.repeat);
            return msg;
        } else {
            Account account = new Account();
            if (isEncryption.equals("false")){
                account.setUserPassword(DigestUtils.md5Hex(password));
            }else if ("true".equals(isEncryption)){
                account.setUserPassword(password);
            }else {
                msg.setCode(Code.Paramerror);
                msg.setMsg(Code.ParamerrorMsg);
                return msg;
            }
            String uuid = GetUUID.uuid();
            account.setAccountState("正常");
            account.setCellphoneNumber(accountNumber);
            account.setBeiYongEr("user");
            account.setUserName(userName);
            account.setId(uuid);
            account.setUserEmail(email);
            account.setCreatTime(new Date());
            account.setBeiYongSan("http://pwsp9j66o.bkt.clouddn.com/acountmsg.jpg");
            int i = accountMapper.insertSelective(account);
            RoleAccountKey roleAccountKey = new RoleAccountKey();
            roleAccountKey.setAccountId(uuid);
            roleAccountKey.setRoleId("2");
            roleAccountKey.setId(GetUUID.uuid());
            int aroleKey = roleAccountKeyMapper.insertSelective(roleAccountKey);
            if (i>0 && aroleKey>0){
//              TODO 发送邮件激活
                msg.setCode(Code.sucess);
                msg.setMsg(Code.sucessMsg);
            }
            return msg;
        }


    }

    /**
     * 查看用户信息
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Msg selectAccountmsg(Integer page, Integer size) {
        Msg msg = GetMsg.getMsg();
        PageHelper.startPage(page,size);
        List<Account> accounts = accountMapper.selaccountRole();
        PageInfo<Account> pageInfo = new PageInfo<>(accounts);
        msg.setCode(Code.layuisucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(pageInfo.getList());
        msg.setCount(Long.toString(pageInfo.getTotal()));
        return msg;
    }

    /**
     * 跟新用户信息
     *
     * @param account1
     */
    @Override
    public int updateaccount(Account account1) {
        int i = accountMapper.updateByPrimaryKeySelective(account1);
        return i;
    }

    /**
     * 根据id查询用户
     *
     * @param account
     * @return
     */
    @Override
    public Account selectAccount(Account account) {
        if (account != null && !"".equals(account.getId())) {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andIdEqualTo(account.getId());
            List<Account> accounts = accountMapper.selectByExample(accountExample);
            if (accounts.size() > 0) {
                return accounts.get(0);
            }
        }
        return null;
    }

    /**
     * 根据id查询用户
     *
     * @param account
     * @return
     */
    @Override
    public Account selectAccount(String accountId) {
        if (accountId != null || !"".equals(accountId)) {
            AccountExample accountExample = new AccountExample();
            AccountExample.Criteria criteria = accountExample.createCriteria();
            criteria.andIdEqualTo(accountId);
            List<Account> accounts = accountMapper.selectByExample(accountExample);
            if (accounts.size() > 0) {
                return accounts.get(0);
            }
        }
        return null;
    }

    /**
     * 是否存在当前账号
     *
     * @return
     */
    public boolean isAccount(String accountNumber) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andCellphoneNumberEqualTo(accountNumber);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        if (accounts.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
