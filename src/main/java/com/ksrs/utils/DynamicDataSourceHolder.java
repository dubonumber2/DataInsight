package com.ksrs.utils;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> THREAD_DATA_SOURCE=new ThreadLocal<String>();
    public static String getDataSource(){
        return THREAD_DATA_SOURCE.get();
    }
    public static void setDataSource(String dataSource) {
        THREAD_DATA_SOURCE.set(dataSource);
    }
    public static void clearDataSource() {
        THREAD_DATA_SOURCE.remove();
    }

}
