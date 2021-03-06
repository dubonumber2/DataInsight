package com.ksrs.utils;


import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class LayUiUtils<T> {
    private int code;
    private String msg;
    private long count;
    private List<T> data;


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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {

        this.data = data;
    }

    public static void main(String[] args) {
        Jedis jedis=new Jedis("10.0.0.96");
        System.out.println(jedis.ping());
        jedis.set("dubo","love yjx");
        System.out.println(jedis.get("dubo"));
    }
}
