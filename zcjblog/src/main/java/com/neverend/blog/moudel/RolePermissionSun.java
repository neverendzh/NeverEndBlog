package com.neverend.blog.moudel;

import com.neverend.blog.entity.RolePermission;

public class RolePermissionSun extends RolePermission {
     private String temporaryMy;
     private String  userMy;
     private String  adminMy;
     private String  superMy;
     private String  errormy;

    public String getTemporaryMy() {
        return temporaryMy;
    }

    public void setTemporaryMy(String temporaryMy) {
        this.temporaryMy = temporaryMy;
    }

    public String getUserMy() {
        return userMy;
    }

    public void setUserMy(String userMy) {
        this.userMy = userMy;
    }

    public String getAdminMy() {
        return adminMy;
    }

    public void setAdminMy(String adminMy) {
        this.adminMy = adminMy;
    }

    public String getSuperMy() {
        return superMy;
    }

    public void setSuperMy(String superMy) {
        this.superMy = superMy;
    }

    public String getErrormy() {
        return errormy;
    }

    public void setErrormy(String errormy) {
        this.errormy = errormy;
    }

    @Override
    public String toString() {
        return "RolePermissionSun{" +
                "TemporaryMy='" + temporaryMy + '\'' +
                ", userMy='" + userMy + '\'' +
                ", adminMy='" + adminMy + '\'' +
                ", superMy='" + superMy + '\'' +
                ", errormy='" + errormy + '\'' +
                '}';
    }
}
