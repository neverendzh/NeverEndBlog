package com.neverend.blog.util.email.weixin;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.neverend.blog.exception.ServiceException;
import com.neverend.blog.moudel.weixin.BuMenMSg;
import com.neverend.blog.moudel.weixin.WeiXiUserMsg;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class WeiXinUtil {

    private static final String tukenCahe = "sendMsgTokem";
    /**
     * 获取部分成员
     */
    private static final String GET_BU_MEN_CHENG_YUAN = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=%s&department_id=%s&fetch_child=%s";

    /**
     * 获取AccessToken的URL
     */
    private static final String GET_ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";
    /**
     * 创建部门的URL
     */
    private static final String POST_DEPT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=%s";
    /**
     * 删除部门的URL
     */
    private static final String GET_DELETE_DEPT_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=%s&id=%s";

    /**
     * 创建员工的URL
     */
    private static final String POST_CREATE_ACCOUNT_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=%s";

    /**
     * 删除员工的URL
     */
    private static final String GET_DELETE_ACCOUNT_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=%s&userid=%s";

    /**
     * 发送消息的URL
     */
    private static final String POST_SEND_MESSAGE = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";

    @Value("${weixin.corpID}")
    private String corpID;
    @Value("${weixin.secret}")
    private String secret;
    @Value("${weixin.app.agentid}")
    private Integer agentId;

    /**
     * AccessToken的缓存
     */
    private LoadingCache<String, String> accessTokenCache = CacheBuilder.newBuilder()
            .expireAfterWrite(7200, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String type) throws Exception {
                    String url = String.format(GET_ACCESS_TOKEN_URL, corpID, secret);
                    String resultJson = sendHttpGetRequest(url);
                    Map<String, Object> map = JSON.parseObject(resultJson, HashMap.class);
                    if (map.get("errcode").equals(0)) {
                        return (String) map.get("access_token");
                    }
                    throw new ServiceException(resultJson);
                }
            });


    /**
     * 获取AccessToken
     *
     * @param type 获取AccessToken的类型  normal  Contacts
     * @return
     */
    public String getAccessToken(String type) {
        try {
            return accessTokenCache.get(type);
        } catch (ExecutionException e) {
            throw new RuntimeException("获取AccessToken异常", e);
        }
    }


    /**
     * 发送文本消息给用户
     *
     * @param userIdList 接收消息的用户ID
     * @param message    消息内容（支持转义字符和html）
     */
    public void sendTextMessageToUser(List<Integer> userIdList, String message) {
        String url = String.format(POST_SEND_MESSAGE, getAccessToken(tukenCahe));
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer userId : userIdList) {
            stringBuilder.append(userId).append("|");
        }
        String idString = stringBuilder.toString();
        idString = idString.substring(0, idString.lastIndexOf("|"));

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("touser", "fankay");
        data.put("msgtype", "text");
        data.put("agentid", agentId);
        Map<String, String> messageMap = new HashMap<String, String>();
        messageMap.put("content", message);
        data.put("text", messageMap);

        String resultJson = sendHttpPostRequest(url, JSON.toJSONString(data));

        Map<String, Object> resultMap = JSON.parseObject(resultJson, HashMap.class);
        if (!resultMap.get("errcode").equals(0)) {
            throw new ServiceException("发送文本消息失败: " + resultJson);
        }
    }


    /**
     * 发出Http的get请求
     *
     * @Param url 请求的URL地址
     */
    private String sendHttpGetRequest(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException ex) {
            throw new RuntimeException("HTTP请求异常", ex);
        }
    }

    /**
     * 发出Http的Post请求
     *
     * @param url  目标的URL
     * @param json 请求体
     */
    private String sendHttpPostRequest(String url, String json) {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        //通过JSON格式构建Post的请求体
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException ex) {
            throw new RuntimeException("HTTP请求异常", ex);
        }
    }


    public int sendTextMessageToUsers(List<String> userIdList, String message) {
        String url = String.format(POST_SEND_MESSAGE, getAccessToken(tukenCahe));
        StringBuilder stringBuilder = new StringBuilder();
        for (String userId : userIdList) {
            stringBuilder.append(userId).append("|");
        }
        String idString = stringBuilder.toString();
        idString = idString.substring(0, idString.lastIndexOf("|"));

        Map<String, Object> data = new HashMap<String, Object>();
//        接收的用户
        data.put("touser", idString);
        data.put("msgtype", "text");
        data.put("agentid", agentId);
        Map<String, String> messageMap = new HashMap<String, String>();
        messageMap.put("content", message);
        data.put("text", messageMap);

        String resultJson = sendHttpPostRequest(url, JSON.toJSONString(data));

        Map<String, Object> resultMap = JSON.parseObject(resultJson, HashMap.class);
        if (!resultMap.get("errcode").equals(0)) {
            throw new ServiceException("发送文本消息失败: " + resultJson);
        }else {
            return 0;
        }
    }

    /**
     * 获取部门并且发送消息
     * @param msg
     * @return
     */
    public int getBufenUser(String msg) {
        String url = String.format(GET_BU_MEN_CHENG_YUAN, getAccessToken(tukenCahe), 2, 0);
        String resultJson = sendHttpGetRequest(url);
        BuMenMSg buMenMSg = JSON.parseObject(resultJson, BuMenMSg.class);
        List<WeiXiUserMsg> userlist = buMenMSg.getUserlist();
        List<String> strings = new ArrayList<>();
        for (WeiXiUserMsg weiXiUserMsg : userlist) {
            strings.add(weiXiUserMsg.getUserid());
        }
        int i = sendTextMessageToUsers(strings, msg);
        return i;
    }

}
