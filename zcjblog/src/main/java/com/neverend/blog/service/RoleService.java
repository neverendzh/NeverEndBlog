package com.neverend.blog.service;

import com.neverend.blog.moudel.Msg;
import org.springframework.stereotype.Service;

public interface RoleService {
    /**
     * 获取角色
     * @return
     */
   Msg getRoles();

    /**
     * 修改用户角色
     * @param accountid
     * @param roleid
     * @return
     */
    Msg editRoles(String accountid, String roleid);

    /**
     * 解除或禁用用户
     * @param accountid
     * @param isLock
     * @return
     */
    Msg editlockAccount(String accountid, boolean isLock);
}
