package com.neverend.blog.security;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountLoginLog;
import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.entity.Roles;
import com.neverend.blog.service.AccountService;
import com.neverend.blog.service.RolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author zcg
 */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * �жϽ�ɫ��Ȩ��
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //��ȡ��ǰ��¼�Ķ���
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        //��ȡ��ǰ��¼����ӵ�еĽ�ɫ
        List<Roles> rolesList = rolePermissionService.findRolesByAccountId(account.getId());
        //��ȡ��ǰ��¼����ӵ�е�Ȩ��
        List<RolePermission> permissionList = new ArrayList<>();
        for(Roles roles : rolesList) {
            List<RolePermission> rolesPermissionList = rolePermissionService.findAllPermissionByRolesId(roles.getRoleId());
            permissionList.addAll(rolesPermissionList);
        }

        Set<String> rolesNameSet = new HashSet<>();
        for(Roles roles : rolesList) {
            rolesNameSet.add(roles.getRolesCode());
        }

        Set<String> permissionNameSet = new HashSet<>();
        for(RolePermission permission : permissionList) {
            permissionNameSet.add(permission.getPermissionCode());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //��ǰ�û�ӵ�еĽ�ɫ��code��
        simpleAuthorizationInfo.setRoles(rolesNameSet);
        //��ǰ�û�ӵ�е�Ȩ��(code)
        simpleAuthorizationInfo.setStringPermissions(permissionNameSet);
        return simpleAuthorizationInfo;
    }

    /**
     * �жϵ�¼
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userMobile = usernamePasswordToken.getUsername();
        if(userMobile != null) {
            Account account = accountService.findByMobile(userMobile);
            if(account == null) {
                throw new UnknownAccountException("�Ҳ������˺�:" + userMobile);
            } else {
                if(Account.STATE_NORMAL.equals(account.getAccountState())) {
                        logger.info("{} ��¼�ɹ�: {}",account,usernamePasswordToken.getHost());
                        //�����¼��־
                        Date date = new Date();
                        Long lime = date.getTime();
                        AccountLoginLog accountLoginLog = new AccountLoginLog();
                        accountLoginLog.setId(Long.toString(lime));
                        accountLoginLog.setLoginTime(new Date());
                        accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                        accountLoginLog.setAccountId(account.getId());
                        accountService.saveAccountLoginLog(accountLoginLog);
                        return new SimpleAuthenticationInfo(account,account.getUserPassword(),getName());

                } else {
                    throw new LockedAccountException("�˺ű����û�����:" + account.getAccountState());
                }
            }
        }
        return null;
    }
}
