package com.ksrs.entity;

public class User_operation {
    private String user_company;
    private String realname;
    private String operation_name;
    private String operation_explain;
    private String user_name;
    private String operation_time;
    private String sumcount;
    private int dowloadcount;
    private String user_type;
    private String statistic_time;

    public String getStatistic_time() {
        return statistic_time;
    }

    public void setStatistic_time(String statistic_time) {
        this.statistic_time = statistic_time;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getSumcount() {
        return sumcount;
    }

    public void setSumcount(String sumcount) {
        this.sumcount = sumcount;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public void setOperation_name(String operation_name) {
        this.operation_name = operation_name;
    }

    public String getOperation_explain() {
        return operation_explain;
    }

    public void setOperation_explain(String operation_explain) {
        this.operation_explain = operation_explain;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOperation_time() {
        return operation_time;
    }

    public void setOperation_time(String operation_time) {
        this.operation_time = operation_time;
    }

    public int getDowloadcount() {
        return dowloadcount;
    }

    public void setDowloadcount(int dowloadcount) {
        this.dowloadcount = dowloadcount;
    }
}
