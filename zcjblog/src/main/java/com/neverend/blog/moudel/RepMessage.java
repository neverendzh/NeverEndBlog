package com.neverend.blog.moudel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="留言信息", description="留言信息，留言回复信息")
public class RepMessage {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "用户id")
    private String accountId;
    @ApiModelProperty(value = "当前信息id")
    private String messageId;
    @ApiModelProperty(value = "隶属回复的信息id，如果为空则属于留言")
    private String messagePid;
    @ApiModelProperty(value = "信息详情")
    private String message;
    @ApiModelProperty(value = "时间")
    private Date time;
    @ApiModelProperty(value = "该信息的用户名称")
    private String hfname;

    @Override
    public String toString() {
        return "RepMessage{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messagePid='" + messagePid + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", hfname='" + hfname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessagePid() {
        return messagePid;
    }

    public void setMessagePid(String messagePid) {
        this.messagePid = messagePid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getHfname() {
        return hfname;
    }

    public void setHfname(String hfname) {
        this.hfname = hfname;
    }
}
