package com.neverend.blog.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
public class SuperLanMu implements Serializable {
    private String superLanMuId;

    private String lanMuName;
    List<LanMu> lanMus;
    private static final long serialVersionUID = 1L;

    public List<LanMu> getLanMus() {
        return lanMus;
    }

    public void setLanMus(List<LanMu> lanMus) {
        this.lanMus = lanMus;
    }

    @Override
    public String toString() {
        return "SuperLanMu{" +
                "superLanMuId='" + superLanMuId + '\'' +
                ", lanMuName='" + lanMuName + '\'' +
                ", lanMus=" + lanMus +
                '}';
    }

    public String getSuperLanMuId() {
        return superLanMuId;
    }

    public void setSuperLanMuId(String superLanMuId) {
        this.superLanMuId = superLanMuId;
    }

    public String getLanMuName() {
        return lanMuName;
    }

    public void setLanMuName(String lanMuName) {
        this.lanMuName = lanMuName;
    }
}