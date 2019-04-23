package com.neverend.blog.service;

import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.entity.Roles;

import java.util.List;

public interface RolePermissionService {
    List<Roles> findRolesByAccountId(String id);

    List<RolePermission> findAllPermissionByRolesId(String roleId);

    List<RolePermission> findAllPermission();

}
