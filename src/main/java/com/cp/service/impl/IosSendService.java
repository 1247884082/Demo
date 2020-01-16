package com.cp.service.impl;


import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.CIDResult;
import cn.jpush.api.push.GroupPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.*;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.*;
import com.cp.service.SendService;
import com.cp.vo.IosMessageVO;
import com.cp.vo.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 苹果消息推送服务
 */
public class IosSendService implements SendService {


    protected static final Logger LOG = LoggerFactory.getLogger(IosSendService.class);
    protected static final String APP_KEY = "e3850842eebc8f960aa0a515";
    protected static final String MASTER_SECRET = "f13537d887ff9ba27d2c814a";


    public Result sendMessage(Object object) throws Exception {
        IosMessageVO iosMessageVO = (IosMessageVO) object;
        ClientConfig clientConfig = ClientConfig.getInstance();
        final JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(iosMessageVO.getRegistrationIds()))
                .setNotification(Notification.alert(iosMessageVO.getContent()))
                .build();
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            System.out.println(result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            LOG.error("Sendno: " + payload.getSendno());
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
        }
        return null;
    }


}
