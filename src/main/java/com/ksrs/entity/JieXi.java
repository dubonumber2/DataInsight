package com.ksrs.entity;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class JieXi {
    private String name;
    private String JxName;
    private long number;
    private long detNum;
    private String detDate;
    private double jxl;
    private String createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJxName() {
        return JxName;
    }

    public void setJxName(String jxName) {
        JxName = jxName;
    }

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

    public String getDetDate() {
        return detDate;
    }

    public void setDetDate(String detDate) {
        this.detDate = detDate;
    }

    public double getJxl() {
        return jxl;
    }

    public void setJxl(double jxl) {
        this.jxl = jxl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
