package com.neverend.blog.service;

import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.entity.Roles;
import com.neverend.blog.moudel.Msg;

import java.util.List;

public interface RolePermissionService {
    List<Roles> findRolesByAccountId(String id);

    List<RolePermission> findAllPermissionByRolesId(String roleId);

    List<RolePermission> findAllPermission();

    /**
     * 查看url链接
     * @param page
     * @param num
     * @return
     */
    Msg findAllPermissionMsg(Integer page,Integer num);

    /**
     *
     * @param id 菜单id
     * @param secrityName 权限名称
     * @param iskq  是否开启当前传递的权限名称  true 开启当前权限， false 撤销当前权限
     * @return
     */
    Msg openCloseSecrity(String id, String secrityName, boolean iskq);

    /**
     * 添加url权限链接
     * @param urlName
     * @return
     */
    Msg addurl(String urlName,String typeName);
}
