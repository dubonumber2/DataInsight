package com.ksrs.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class Statistics {
    private int id;
    private String name;
    private long number;
    private long detNum;
    private String detDate;
    private long analysisNum;
    private String analysisDFate;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getAnalysisNum() {
        return analysisNum;
    }

    public void setAnalysisNum(long analysisNum) {
        this.analysisNum = analysisNum;
    }

    public String getAnalysisDFate() {
        return analysisDFate;
    }

    public void setAnalysisDFate(String analysisDFate) {
        this.analysisDFate = analysisDFate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
