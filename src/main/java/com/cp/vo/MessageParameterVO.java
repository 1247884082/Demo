package com.cp.vo;

public class MessageParameterVO {

    /**
     * 参数动作类型 1审核
     */
    private Integer messageType;

    /**
     * 参数动作实体 比如审核model
     */
    private Object object;

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
