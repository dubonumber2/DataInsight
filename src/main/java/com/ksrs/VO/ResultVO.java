package com.ksrs.VO;

/**
 * 用于返回HTTP请求结果，统一格式
 */
public class ResultVO<T> {
    /** 返回的状态码 **/
    private int code;
    /** 返回的信息 **/
    private String msg;

    /** 返回的数据 **/
    private T data;

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{\"code\": "+code+",\"msg\": \""+msg+"\",\"data\": "+data+"}";
    }
}
