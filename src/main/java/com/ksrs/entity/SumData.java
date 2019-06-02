package com.ksrs.entity;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
public class SumData {
    private long sumIncrementList;
    private long sumIncrementDetail;
    private long sumUpdateListNumber;
    private long updateDetailNum;

    public long getSumIncrementList() {
        return sumIncrementList;
    }

    public void setSumIncrementList(long sumIncrementList) {
        this.sumIncrementList = sumIncrementList;
    }

    public long getSumIncrementDetail() {
        return sumIncrementDetail;
    }

    public void setSumIncrementDetail(long sumIncrementDetail) {
        this.sumIncrementDetail = sumIncrementDetail;
    }

    public long getSumUpdateListNumber() {
        return sumUpdateListNumber;
    }

    public void setSumUpdateListNumber(long sumUpdateListNumber) {
        this.sumUpdateListNumber = sumUpdateListNumber;
    }

    public long getUpdateDetailNum() {
        return updateDetailNum;
    }

    public void setUpdateDetailNum(long updateDetailNum) {
        this.updateDetailNum = updateDetailNum;
    }
}
