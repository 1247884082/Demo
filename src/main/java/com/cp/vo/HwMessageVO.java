package com.cp.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 消息信息
 * @author fzh
 */
public class HwMessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息类型 1通知信息
     */
    private Integer msgType;

    /**
     * 消息图标地址
     */
    private String iconUrl;


    /**
     * 需要发送的appToken集合
     */
    private List<String> appTokens;

    /**
     * 自定义参数
     */
    private Object MessageParameterVO;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<String> getAppTokens() {
        return appTokens;
    }

    public void setAppTokens(List<String> appTokens) {
        this.appTokens = appTokens;
    }

    public Object getMessageParameterVO() {
        return MessageParameterVO;
    }

    public void setMessageParameterVO(Object messageParameterVO) {
        MessageParameterVO = messageParameterVO;
    }
}
