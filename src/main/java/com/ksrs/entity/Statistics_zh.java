package com.ksrs.entity;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public class Statistics_zh {
    private String type;
    private int mongoCount;
    private int mysqlCount;
    private int mongoIncrement;
    private int mysqlIncrement;
    private int errorCount;
    private String mongoNewTime;
    private String overTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMongoCount() {
        return mongoCount;
    }

    public void setMongoCount(int mongoCount) {
        this.mongoCount = mongoCount;
    }

    public int getMysqlCount() {
        return mysqlCount;
    }

    public void setMysqlCount(int mysqlCount) {
        this.mysqlCount = mysqlCount;
    }

    public int getMongoIncrement() {
        return mongoIncrement;
    }

    public void setMongoIncrement(int mongoIncrement) {
        this.mongoIncrement = mongoIncrement;
    }

    public int getMysqlIncrement() {
        return mysqlIncrement;
    }

    public void setMysqlIncrement(int mysqlIncrement) {
        this.mysqlIncrement = mysqlIncrement;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public String getMongoNewTime() {
        return mongoNewTime;
    }

    public void setMongoNewTime(String mongoNewTime) {
        this.mongoNewTime = mongoNewTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }
}
