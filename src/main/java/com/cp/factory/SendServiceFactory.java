package com.cp.factory;

import com.cp.service.SendService;
import com.cp.service.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机消息推送工厂类
 */
public class SendServiceFactory {

    /**
     * IOS 苹果
     * HW 华为
     * VIVO vivo
     * OPPO oppo
     * MZ 魅族
     * XM 小米
     * KP 酷派
     * ZX 中信
     * NJY 诺基亚
     * LG LG
     * SX 三星
     */
    public enum SendType {IOS, HW, VIVO, OPPO, MZ, XM, KP, ZX, CZ, NJY, LG, SX}

    ;


    private static Map<SendType, SendService> sendServiceMap = new HashMap();

    static {
        sendServiceMap.put(SendType.IOS, new IosSendService());
        sendServiceMap.put(SendType.HW, new HwSendService());
        sendServiceMap.put(SendType.VIVO, new VivoSendService());
        sendServiceMap.put(SendType.OPPO, new OppoSendService());
        sendServiceMap.put(SendType.MZ, new MzSendService());
        sendServiceMap.put(SendType.XM, new XmSendService());
        sendServiceMap.put(SendType.KP, new KpSendService());
        sendServiceMap.put(SendType.ZX, new ZxSendService());
        sendServiceMap.put(SendType.CZ, new CzSendService());
        sendServiceMap.put(SendType.NJY, new NjySendService());
        sendServiceMap.put(SendType.LG, new LgSendService());
        sendServiceMap.put(SendType.SX, new SxSendService());
    }

    public static SendService getSendService(SendType sendType) {
        SendService sendService = sendServiceMap.get(sendType);
        return sendService;
    }

}
