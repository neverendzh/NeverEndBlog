package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class RolePermission implements Serializable {

    public static final String MENU_TYPE = "菜单";
    public static final String BUTTON_TYPE = "按钮";

    private String id;

    private String permissionName;

    private String permissionCode;

    private String permissionType;

    private String parentId;

    private Date creatTime;

    private Date updateTime;

    private String url;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                ", permissionType='" + permissionType + '\'' +
                ", parentId='" + parentId + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", url='" + url + '\'' +
                '}';
    }
}