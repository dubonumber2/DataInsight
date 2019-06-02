package com.ksrs.entity;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public class MongoStatistics {
    private String at_title;
    private String at_type;
    private String at_mysql_table;
    private String at_mongodb_collection;
    private String at_mongodb_source;

    public String getAt_mongodb_source() {
        return at_mongodb_source;
    }

    public void setAt_mongodb_source(String at_mongodb_source) {
        this.at_mongodb_source = at_mongodb_source;
    }

    public String getAt_title() {
        return at_title;
    }

    public void setAt_title(String at_title) {
        this.at_title = at_title;
    }

    public String getAt_type() {
        return at_type;
    }

    public void setAt_type(String at_type) {
        this.at_type = at_type;
    }

    public String getAt_mysql_table() {
        return at_mysql_table;
    }

    public void setAt_mysql_table(String at_mysql_table) {
        this.at_mysql_table = at_mysql_table;
    }

    public String getAt_mongodb_collection() {
        return at_mongodb_collection;
    }

    public void setAt_mongodb_collection(String at_mongodb_collection) {
        this.at_mongodb_collection = at_mongodb_collection;
    }
}
