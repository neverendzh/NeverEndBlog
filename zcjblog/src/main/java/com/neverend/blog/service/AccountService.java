package com.neverend.blog.service;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountLoginLog;
import com.neverend.blog.moudel.Msg;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
public interface AccountService {

    Account findByMobile(String userMobile);

    void saveAccountLoginLog(AccountLoginLog accountLoginLog);

    Account selectAccount(Account account);
    Account selectAccount(String accountId);

    /**
     * 账号注册
     * @param userName
     * @param accountNumber
     * @param password
     * @param isEncryption
     * @return
     */
    @Transactional
    public Msg registeredAccount(String userName, String accountNumber, String password, String isEncryption,String email);
}
