package com.neverend.blog.service.impl;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.neverend.blog.entity.RolePermission;
import com.neverend.blog.entity.RolePermissionExample;
import com.neverend.blog.entity.Roles;
import com.neverend.blog.mapper.RolePermissionMapper;
import com.neverend.blog.mapper.RolesMapper;
import com.neverend.blog.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("ALL")
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * 根据用户id查询该用户所有的角色集合
     * @param id
     * @return
     */
    @Override
    public List<Roles> findRolesByAccountId(String id) {
        return rolesMapper.findRolesByAccountId(id);
    }

    /**
     * 根据角色id查询该角色下的细粒度权限集合
     * @param roleId
     * @return
     */
    @Override
    public List<RolePermission> findAllPermissionByRolesId(String roleId) {
        return rolePermissionMapper.findAllByRolesId(roleId);
    }

    /**
     * 查询所有的权限
     * @return
     */
    @Override
    public List<RolePermission> findAllPermission() {
        RolePermissionExample permissionExample = new RolePermissionExample();
        List<RolePermission> permissionList = rolePermissionMapper.selectByExample(permissionExample);
        List<RolePermission> resultList = new ArrayList<>();
        treeList(permissionList,resultList,0);
        return resultList;
    }

    /**
     * 将查询数据库的角色列表转换为树形集合结果
     * @param sourceList 数据库查询出的集合
     * @param endList 转换结束的结果集合
     * @param parentId 父ID
     */
    private void treeList(List<RolePermission> sourceList, List<RolePermission> endList, int parentId) {
        List<RolePermission> tempList = Lists.newArrayList(Collections2.filter(sourceList, RolePermission -> RolePermission.getParentId().equals(parentId+"")));
        for(RolePermission permission : tempList) {
            endList.add(permission);
            treeList(sourceList,endList,Integer.valueOf(permission.getId()));
        }
    }
}
