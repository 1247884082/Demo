package com.cp.vo;

import java.io.Serializable;

/**
 * <p>
 *  Controller返回结果
 * </p>
 *
 * @author lz
 * @since 2018-11-1
 */
public class Result implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static Integer RESULT_SUCCESS = 0;//成功
    public final static Integer RESULT_ERROR = 2;//失败


    /**
     * 返回代码
     */
    private Integer code = RESULT_SUCCESS;

    /**
     * 返回提示语
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
