package com.neverend.blog.moudel;

import com.neverend.blog.entity.Article;
import com.neverend.blog.entity.SuperArticleSort;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zcj
 * json返回信息
 */
@ApiModel(value="返回的数据信息", description="大部分请求的返回的json数据信息")
public class Msg<T>{
    /**
     * 返回状态码
     */
    @ApiModelProperty(value="返回状态码;200=ok;401=无权限;301=重新登陆;500=服务异常;407=重复;404=不存在")
    private String code;
    /**
     * 返回成功，或错误的异常提示信息
     */
    @ApiModelProperty(value="返回成功，或错误的异常提示信息")
    private String msg;
    /**
     * 如果是返回数据页数
     */
    @ApiModelProperty(value="如果是返回数据页数")
    private String count;
    /**
     * 可能会用到，用于设置跳转的url
     */
    @ApiModelProperty(value="可能会用到，用于设置跳转的url")
    private String url;
    /**
     * 设置其他返回信息Object
     */
    @ApiModelProperty(value="通用数据信息")
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
