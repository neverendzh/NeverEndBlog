package com.neverend.blog.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class RolesPermissionKey implements Serializable {
    private String id;

    /**
     * 角色id
     */
    private String rolesId;

    /**
     * 权限id
     */
    private String permissionId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolesId() {
        return rolesId;
    }

    public void setRolesId(String rolesId) {
        this.rolesId = rolesId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}