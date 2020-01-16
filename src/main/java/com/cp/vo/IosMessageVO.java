package com.cp.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 消息信息
 * @author fzh
 */
public class IosMessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息内容
     */
    private String content;

    /**
     * ios端id
     */
    private List<String> registrationIds;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(List<String> registrationIds) {
        this.registrationIds = registrationIds;
    }
}
