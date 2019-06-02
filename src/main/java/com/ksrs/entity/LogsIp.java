package com.ksrs.entity;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class LogsIp {
    private int ipSendHttp;
    private int sendHttpCounts;
    private int sendRedCounts;
    private int sendVisitCounts;
    private String countTime;

    public int getSendHttpCounts() {
        return sendHttpCounts;
    }

    public void setSendHttpCounts(int sendHttpCounts) {
        this.sendHttpCounts = sendHttpCounts;
    }

    public int getSendRedCounts() {
        return sendRedCounts;
    }

    public void setSendRedCounts(int sendRedCounts) {
        this.sendRedCounts = sendRedCounts;
    }

    public int getSendVisitCounts() {
        return sendVisitCounts;
    }

    public void setSendVisitCounts(int sendVisitCounts) {
        this.sendVisitCounts = sendVisitCounts;
    }

    public int getIpSendHttp() {
        return ipSendHttp;
    }

    public void setIpSendHttp(int ipSendHttp) {
        this.ipSendHttp = ipSendHttp;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
