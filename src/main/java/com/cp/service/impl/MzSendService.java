package com.cp.service.impl;

import com.alibaba.fastjson.JSON;
import com.cp.service.SendService;
import com.cp.vo.Result;
import com.meizu.push.sdk.server.IFlymePush;
import com.meizu.push.sdk.server.constant.ResultPack;
import com.meizu.push.sdk.server.model.push.PushResult;
import com.meizu.push.sdk.server.model.push.VarnishedMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 魅族消息推送服务
 */
public class MzSendService implements SendService {


    private static String APP_SECRET_KEY = "";
    private static Long appId = 123L;

    public Result sendMessage(Object object) throws Exception {
        //推送对象
        IFlymePush push = new IFlymePush(APP_SECRET_KEY, true);
        //组装消息
        VarnishedMessage message = new VarnishedMessage.Builder().appId(appId)
                .title("推送标题").content("推送内容")
                .noticeExpandType(1)
                .noticeExpandContent("展开文本内容")
                .clickType(2).url("http://www.baidu.com").parameters(JSON.parseObject("{\"k1\":\"value1\",\"k2\":0,\"k3\":\"value3\"}"))
                .offLine(true).validTime(12)
                .suspend(true).clearNoticeBar(true).vibrate(true).lights(true).sound(true)
                .build();

        //目标用户
        List<String> pushIds = new ArrayList<String>();
        pushIds.add("pusId1");
        pushIds.add("pushId2");
        try {
            ResultPack<PushResult> pushResultResultPack = push.pushMessage(message, pushIds, 10);
            System.out.println(pushResultResultPack);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
