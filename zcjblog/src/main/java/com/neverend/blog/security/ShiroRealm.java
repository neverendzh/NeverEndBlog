package com.neverend.blog.security;

import com.neverend.blog.entity.Account;
import com.neverend.blog.entity.AccountLoginLog;
import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.entity.Roles;
import com.neverend.blog.service.AccountServiceMyzcj;
import com.neverend.blog.service.RolePermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.*;

/**
 * @author zcg
 */
public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    @Lazy
    private AccountServiceMyzcj accountServiceMyzcj;

    @Autowired
    @Lazy
    private RolePermissionService rolePermissionService;

    /**
     * 判断角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录的对象
        Account account = (Account) principalCollection.getPrimaryPrincipal();
        //获取当前登录对象拥有的角色
        List<Roles> rolesList = rolePermissionService.findRolesByAccountId(account.getId());
        //获取当前登录对象拥有的权限
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
        //当前用户拥有的角色（code）
        simpleAuthorizationInfo.setRoles(rolesNameSet);
        //当前用户拥有的权限(code)
        simpleAuthorizationInfo.setStringPermissions(permissionNameSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 判断登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userMobile = usernamePasswordToken.getUsername();
        if(userMobile != null) {
            Account account = accountServiceMyzcj.findByMobile(userMobile);
            if(account == null) {
                throw new UnknownAccountException("找不到该账号:" + userMobile);
            } else {
                if(Account.STATE_NORMAL.equals(account.getAccountState())) {
                        logger.info("{} 登录成功: {}",account,usernamePasswordToken.getHost());
                        //保存登录日志
                        Date date = new Date();
                        Long lime = date.getTime();
                        AccountLoginLog accountLoginLog = new AccountLoginLog();
                        accountLoginLog.setId(Long.toString(lime));
                        accountLoginLog.setLoginTime(new Date());
                        accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                        accountLoginLog.setAccountId(account.getId());
                        accountServiceMyzcj.saveAccountLoginLog(accountLoginLog);
                        return new SimpleAuthenticationInfo(account,account.getUserPassword(),getName());

                } else {
                    throw new LockedAccountException("账号被禁用或锁定:" + account.getAccountState());
                }
            }
        }
        return null;
    }
}
