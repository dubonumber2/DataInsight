package com.ksrs.entity;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
public class LogsModel {

    //数据源
    private String dataSource;
    //发送的请求总数
    private int httpCounts;
    //抓取的页面数
    private int zqCounts;
    //抓取有效的列表页面数(包括更新)
    private int yxCounts;
    //抓取有效的详情页面数
    private int yxxqCounts;
    //统计的时间
    private String countTime;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public int getHttpCounts() {
        return httpCounts;
    }

    public void setHttpCounts(int httpCounts) {
        this.httpCounts = httpCounts;
    }

    public int getZqCounts() {
        return zqCounts;
    }

    public void setZqCounts(int zqCounts) {
        this.zqCounts = zqCounts;
    }

    public int getYxCounts() {
        return yxCounts;
    }

    public void setYxCounts(int yxCounts) {
        this.yxCounts = yxCounts;
    }

    public int getYxxqCounts() {
        return yxxqCounts;
    }

    public void setYxxqCounts(int yxxqCounts) {
        this.yxxqCounts = yxxqCounts;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
