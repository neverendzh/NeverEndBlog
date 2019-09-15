package com.neverend.blog.service.impl;

import com.neverend.blog.entity.*;
import com.neverend.blog.mapper.AccountMapper;
import com.neverend.blog.mapper.RoleAccountKeyMapper;
import com.neverend.blog.mapper.RolesMapper;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.service.RoleService;
import com.neverend.blog.util.email.GetMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private RoleAccountKeyMapper roleAccountKeyMapper;
    @Autowired
    private AccountMapper accountMapper;
    /**
     * 获取角色
     *
     * @return
     */
    @Override
    public Msg getRoles() {
        RolesExample rolesExample = new RolesExample();
        RolesExample.Criteria criteria = rolesExample.createCriteria();
        List<Roles> roles = rolesMapper.selectByExample(rolesExample);
        Msg msg = GetMsg.getMsg();
        msg.setCode(Code.sucess);
        msg.setMsg(Code.sucessMsg);
        msg.setData(roles);
        msg.setCount(Integer.toString(roles.size()));
        return msg;
    }

    /**
     * 修改用户角色
     *
     * @param accountid
     * @param roleid
     * @return
     */
    @Override
    public Msg editRoles(String accountid, String roleid) {
        Msg msg = GetMsg.getMsg();
        RoleAccountKeyExample roleAccountKeyExample = new RoleAccountKeyExample();
        RoleAccountKeyExample.Criteria criteria = roleAccountKeyExample.createCriteria();
        criteria.andAccountIdEqualTo(accountid);
        RoleAccountKey roleAccountKey = new RoleAccountKey();
        roleAccountKey.setRoleId(roleid);
        int i = roleAccountKeyMapper.updateByExampleSelective(roleAccountKey, roleAccountKeyExample);
        if (i>=1){
            msg.setMsg(Code.sucessMsg);
            msg.setCode(Code.sucess);
        }else {
            msg.setMsg(Code.errorMsg);
            msg.setCode(Code.error);
        }
        return msg;
    }

    /**
     * 解除或禁用用户
     *
     * @param accountid
     * @param isLock
     * @return
     */
    @Override
    public Msg editlockAccount(String accountid, boolean isLock) {

        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andIdEqualTo(accountid);
        Account account = new Account();
        if (isLock){
            account.setAccountState(Account.STATE_DISABLE);
        }else {
            account.setAccountState(Account.STATE_NORMAL);
        }
        int i = accountMapper.updateByExampleSelective(account, accountExample);
        Msg msg = GetMsg.getMsg();
        if (i>0){
            msg.setCode(Code.sucess);
            msg.setMsg(Code.sucessMsg);
        }else {
            msg.setMsg(Code.errorMsg);
            msg.setCode(Code.error);
        }
        return msg;
    }
}
