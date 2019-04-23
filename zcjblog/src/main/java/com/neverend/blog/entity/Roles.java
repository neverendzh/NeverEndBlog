package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class Roles implements Serializable {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String rolesName;

    /**
     *
     */
    private String rolesCode;

    private Date creatTime;

    private Date updateTime;

    private List<RolePermission> rolePermissionList;

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public void setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<RolePermission> getRolePermissionList() {
        return rolePermissionList;
    }

    public void setRolePermissionList(List<RolePermission> rolePermissionList) {
        this.rolePermissionList = rolePermissionList;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId='" + roleId + '\'' +
                ", rolesName='" + rolesName + '\'' +
                ", rolesCode='" + rolesCode + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", rolePermissionList=" + rolePermissionList +
                '}';
    }
}