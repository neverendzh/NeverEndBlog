package com.neverend.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.neverend.blog.entity.*;
import com.neverend.blog.mapper.RolePermissionMapper;
import com.neverend.blog.mapper.RolesMapper;
import com.neverend.blog.mapper.RolesPermissionKeyMapper;
import com.neverend.blog.moudel.Code;
import com.neverend.blog.moudel.Msg;
import com.neverend.blog.moudel.RolePermissionSun;
import com.neverend.blog.service.RolePermissionService;
import com.neverend.blog.util.email.GetMsg;
import com.neverend.blog.util.email.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private RolesPermissionKeyMapper rolekeyMapper;

    /**
     * 根据用户id查询该用户所有的角色集合
     *
     * @param id
     * @return
     */
    @Override
    public List<Roles> findRolesByAccountId(String id) {
        return rolesMapper.findRolesByAccountId(id);
    }

    /**
     * 根据角色id查询该角色下的细粒度权限集合
     *
     * @param roleId
     * @return
     */
    @Override
    public List<RolePermission> findAllPermissionByRolesId(String roleId) {
        return rolePermissionMapper.findAllByRolesId(roleId);
    }

    /**
     * 查询所有的权限
     *
     * @return
     */
    @Override
    public List<RolePermission> findAllPermission() {
        RolePermissionExample permissionExample = new RolePermissionExample();
        List<RolePermission> permissionList = rolePermissionMapper.selectByExample(permissionExample);
        List<RolePermission> resultList = new ArrayList<>();
        treeList(permissionList, resultList, 0);
        return resultList;
    }

    @Override
    public Msg findAllPermissionMsg(Integer page, Integer num) {
        Msg msg = GetMsg.getMsg();
        PageHelper.startPage(page, num);
        RolePermissionExample permissionExample = new RolePermissionExample();
        List<RolePermission> permissionList = rolePermissionMapper.selectByExample(permissionExample);
        PageInfo<RolePermission> pageInfo = new PageInfo<>(permissionList);
        List<RolePermission> list = pageInfo.getList();
        List<RolePermissionSun> rolePermissionSuns = getSecrity(list);
        msg.setCode("0");
        msg.setMsg(Code.sucessMsg);
        msg.setCount(pageInfo.getTotal() + "");
        msg.setData(rolePermissionSuns);
        return msg;
    }

    /**
     * @param id          菜单id
     * @param secrityName 权限名称
     * @param iskq        是否开启当前传递的权限名称  true 开启当前权限， false 撤销当前权限
     * @return
     */
    @Override
    public Msg openCloseSecrity(String id, String secrityName, boolean iskq) {
        Msg msg = GetMsg.getMsg();
        if (iskq) {
//            开启
            int i = openSecrity(id, secrityName);
            if (i==1){
                msg.setCode(Code.sucess);
                msg.setMsg(Code.sucessMsg);
                return msg;
            }else {
                msg.setCode(Code.error);
                msg.setMsg(Code.errorMsg);
                return msg;
            }
        } else {
//            关闭
            int i = closeSecrity(id, secrityName);
            if (i>=0){
                msg.setCode(Code.sucess);
                msg.setMsg(Code.sucessMsg);
                return msg;
            }else {
                msg.setCode(Code.error);
                msg.setMsg(Code.errorMsg);
                return msg;
            }
        }
    }

    /**
     * 添加url权限链接
     *
     * @param urlName
     * @return
     */
    @Override
    public Msg addurl(String urlName,String typeName) {
        Msg msg = GetMsg.getMsg();
        PageHelper.startPage(1,1);
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.setOrderByClause("CAST( permission_code as signed) DESC");
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        Integer code = 0;
        Integer id = 0;
        if (!rolePermissions.isEmpty() && rolePermissions.size()>0){
            RolePermission rolePermission = rolePermissions.get(0);
            code = Integer.valueOf(rolePermission.getPermissionCode())+1;

            RolePermissionExample rolePermissionExampleid = new RolePermissionExample();
            rolePermissionExampleid.setOrderByClause("CAST( id as signed) DESC");
            List<RolePermission> rolePermissionsid = rolePermissionMapper.selectByExample(rolePermissionExampleid);
            if (!rolePermissionsid.isEmpty() && rolePermissionsid.size()>0){
                RolePermission rolePermissionid = rolePermissionsid.get(0);
                id = Integer.valueOf(rolePermissionid.getId())+1;
            }
        }else {
           code=code+1;
        }

        RolePermission permission = new RolePermission();
        permission.setId(Integer.toString(id));
        permission.setPermissionName(typeName);
        permission.setPermissionCode(Integer.toString(code));
        permission.setPermissionType("100");
        permission.setParentId("0");
        permission.setCreatTime(new Date());
        permission.setUpdateTime(new Date());
        permission.setUrl(urlName);
        int insert = rolePermissionMapper.insert(permission);
        if (insert==1){
            msg.setMsg(Code.sucessMsg);
            msg.setCode(Code.sucess);
        }else {
            msg.setCode(Code.error);
            msg.setCode(Code.errorMsg);
        }
        return msg;
    }

    private int closeSecrity(String id, String secrityName) {
        List<Roles> roles = getRoles(secrityName);
        if (!roles.isEmpty() && roles.size() > 0) {
            String roleId = roles.get(0).getRoleId();
            RolesPermissionKeyExample rolesPermissionKeyExample = new RolesPermissionKeyExample();
            RolesPermissionKeyExample.Criteria criteria = rolesPermissionKeyExample.createCriteria();
            criteria.andRolesIdEqualTo(roleId);
            criteria.andPermissionIdEqualTo(id);
            int i = rolekeyMapper.deleteByExample(rolesPermissionKeyExample);
            return i;
        }else {
            return -1;
        }
    }

    public int openSecrity(String id, String secrityName) {
        List<Roles> roles = getRoles(secrityName);
        if (!roles.isEmpty() && roles.size() > 0) {
            Roles roles1 = roles.get(0);
            String roleId = roles1.getRoleId();
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setId(GetUUID.uuid());
            rolesPermissionKey.setRolesId(roleId);
            rolesPermissionKey.setPermissionId(id);
            return rolekeyMapper.insert(rolesPermissionKey);
        }else {
            return -1;
        }

    }

    private List<Roles> getRoles(String secrityName) {
        RolesExample rolesExample = new RolesExample();
        RolesExample.Criteria criteria = rolesExample.createCriteria();
        criteria.andRolesNameEqualTo(secrityName.trim());
        return rolesMapper.selectByExample(rolesExample);
    }


    private List<RolePermissionSun> getSecrity(List<RolePermission> list) {
        List<RolePermissionSun> rolePermissionSuns = new ArrayList<>();
        for (RolePermission rolePermission : list) {
            RolePermissionSun permissionSun = new RolePermissionSun();
            permissionSun.setId(rolePermission.getId());
            permissionSun.setPermissionName(rolePermission.getPermissionName());
            permissionSun.setPermissionCode(rolePermission.getPermissionCode());
            permissionSun.setCreatTime(rolePermission.getCreatTime());
            permissionSun.setUpdateTime(rolePermission.getUpdateTime());
            permissionSun.setUrl(rolePermission.getUrl());
            RolePermissionSun secrity = rolePermissionMapper.selSecrity(rolePermission.getId());
            if (secrity != null) {
                if (secrity.getSuperMy() != null) {
                    permissionSun.setSuperMy(secrity.getSuperMy());
                } else {
                    permissionSun.setSuperMy("no");
                }
                if (secrity.getAdminMy() != null) {
                    permissionSun.setAdminMy(secrity.getAdminMy());
                } else {
                    permissionSun.setAdminMy("no");
                }
                if (secrity.getUserMy() != null) {
                    permissionSun.setUserMy(secrity.getUserMy());
                } else {
                    permissionSun.setUserMy("no");
                }
                if (secrity.getTemporaryMy() != null) {
                    permissionSun.setTemporaryMy(secrity.getTemporaryMy());
                } else {
                    permissionSun.setTemporaryMy("no");
                }
                if (secrity.getErrormy() != null) {
                    permissionSun.setErrormy(secrity.getErrormy());
                } else {
                    permissionSun.setErrormy("Sucess");
                }
            }
            rolePermissionSuns.add(permissionSun);
        }
        return rolePermissionSuns;
    }

    /**
     * 将查询数据库的角色列表转换为树形集合结果
     *
     * @param sourceList 数据库查询出的集合
     * @param endList    转换结束的结果集合
     * @param parentId   父ID
     */
    private void treeList(List<RolePermission> sourceList, List<RolePermission> endList, int parentId) {
        List<RolePermission> tempList = Lists.newArrayList(Collections2.filter(sourceList, RolePermission -> RolePermission.getParentId().equals(parentId + "")));
        for (RolePermission permission : tempList) {
            endList.add(permission);
            treeList(sourceList, endList, Integer.valueOf(permission.getId()));
        }
    }
}
