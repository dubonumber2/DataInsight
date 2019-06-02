package com.ksrs.entity;

/**
 * 黑龙江龙采的使用报告
 */
public class LongCai {

    /**查询线索数量 **/
    private Integer queryAmount;

    /**返回线索数量**/
    private Integer resultAmount;

    /** 统计时间**/
    private String countTime;

    public Integer getQueryAmount() {
        return queryAmount;
    }

    public void setQueryAmount(Integer queryAmount) {
        this.queryAmount = queryAmount;
    }

    public Integer getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(Integer resultAmount) {
        this.resultAmount = resultAmount;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
