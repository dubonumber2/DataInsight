package com.ksrs.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class CrawlIncrement {
    private String id;
    private String name;
    private long incrementList;
    private long incrementDetail;
    private long updateListNumber;
    private long updateDetailNum;
    private long number;
    private long detNum;
    private String createTime;
    private int data_state;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getDetNum() {
        return detNum;
    }

    public void setDetNum(long detNum) {
        this.detNum = detNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIncrementList() {
        return incrementList;
    }

    public void setIncrementList(long incrementList) {
        this.incrementList = incrementList;
    }

    public long getIncrementDetail() {
        return incrementDetail;
    }

    public void setIncrementDetail(long incrementDetail) {
        this.incrementDetail = incrementDetail;
    }

    public long getUpdateListNumber() {
        return updateListNumber;
    }

    public void setUpdateListNumber(long updateListNumber) {
        this.updateListNumber = updateListNumber;
    }

    public long getUpdateDetailNum() {
        return updateDetailNum;
    }

    public void setUpdateDetailNum(long updateDetailNum) {
        this.updateDetailNum = updateDetailNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getData_state() {
        return data_state;
    }

    public void setData_state(int data_state) {
        this.data_state = data_state;
    }
}
