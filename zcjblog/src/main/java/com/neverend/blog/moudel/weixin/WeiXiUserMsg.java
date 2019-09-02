package com.neverend.blog.moudel.weixin;

import java.util.Arrays;

public class WeiXiUserMsg {
    private String userid;
    private String name;
    private Integer[] department;

    @Override
    public String toString() {
        return "WeiXiUserMsg{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", department=" + Arrays.toString(department) +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getDepartment() {
        return department;
    }

    public void setDepartment(Integer[] department) {
        this.department = department;
    }
}
