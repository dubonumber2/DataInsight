package com.ksrs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 得到昨天的时间 格式为yyyy-MM-dd
      * @return
     */
    public static String getYesterDay(){
        Date date=new Date();
        Date yes=new Date(date.getTime()-86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result=sdf.format(yes);
        return result;
    }

    /**
     * 得到6天以前的时间 格式为yyyy-MM-dd
     * @return
     */
    public static String getAgoDay(){
        Date date=new Date();
        Date yes=new Date(date.getTime()-6*86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result=sdf.format(yes);
        return result;
    }
}
