
package com.neverend.blog.moudel.weixin.jieshouxml;


import java.io.Serializable;


/**
 * 接收处理审核消息企业微信发送的xml消息
 */
public class Xml implements Serializable {
    public String ToUserName;
    public String FromUserName;
    public String CreateTime;
    public String MsgType;
    public String Event;
    public String EventKey;
    public String TaskId;
    public String AgentId;

    public Xml(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey, String taskId, String agentId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Event = event;
        EventKey = eventKey;
        TaskId = taskId;
        AgentId = agentId;
    }

    public String getAgentId() {
        return AgentId;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }


}
