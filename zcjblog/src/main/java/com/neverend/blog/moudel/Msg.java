package com.neverend.blog.moudel;

import com.neverend.blog.entity.SuperArticleSort;

import java.util.List;

/**
 * @author zcj
 * json返回信息
 */
public class Msg {
    private String code;
    private String msg;
    private String count;
    private List<SuperArticleSort> data;
    private String url;
    private Object objectmsg;


    public Object getObjectmsg() {
        return objectmsg;
    }

    public void setObjectmsg(Object objectmsg) {
        this.objectmsg = objectmsg;
    }

    public List<SuperArticleSort> getData() {
        return data;
    }

    public void setData(List<SuperArticleSort> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Msg() {
    }

    public Msg(String code, String url) {
        this.code = code;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                ", url='" + url + '\'' +
                '}';
    }
}
