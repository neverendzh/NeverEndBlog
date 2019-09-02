package com.neverend.blog.moudel.weixin;

import java.util.List;

public class BuMenMSg {
    private int errcode;
    private String msg;
    private List<WeiXiUserMsg> userlist;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WeiXiUserMsg> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<WeiXiUserMsg> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "BuMenMSg{" +
                "errcode=" + errcode +
                ", msg='" + msg + '\'' +
                ", userlist=" + userlist +
                '}';
    }
}
