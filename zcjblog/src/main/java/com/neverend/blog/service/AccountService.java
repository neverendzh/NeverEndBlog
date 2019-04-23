package com.neverend.blog.service;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountLoginLog;

/**
 * @author Administrator
 */
public interface AccountService {

    Account findByMobile(String userMobile);

    void saveAccountLoginLog(AccountLoginLog accountLoginLog);

    Account selectAccount(Account account);
    Account selectAccount(String accountId);
}
