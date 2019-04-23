package com.neverend.blog.moudel;

import java.io.Serializable;

/**
 * @author zcg
 */
public class LanMuUi implements Serializable {
    private String superName;

    private String lanMu;

    private String roleCode;

    private String lookUrl;
    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "LanMuUi{" +
                "superName='" + superName + '\'' +
                ", lanMu='" + lanMu + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", lookUrl='" + lookUrl + '\'' +
                '}';
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getLanMu() {
        return lanMu;
    }

    public void setLanMu(String lanMu) {
        this.lanMu = lanMu;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getLookUrl() {
        return lookUrl;
    }

    public void setLookUrl(String lookUrl) {
        this.lookUrl = lookUrl;
    }
}
