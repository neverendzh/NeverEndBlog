package com.neverend.blog.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class RoleAccountKey implements Serializable {
    private String id;

    private String roleId;

    private String accountId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}