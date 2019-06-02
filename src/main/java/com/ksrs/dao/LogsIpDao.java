package com.ksrs.dao;

import com.ksrs.entity.LogsIp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public interface LogsIpDao {
    /**
     * 得到代理ip发出的请求数
     * @return
     */
    public List<LogsIp> getIpSendHttp();

    /**
     * 得到http请求的堆叠条形图
     * @return
     */
    public List<LogsIp> getSaotu();

    /**
     * 漏斗图
     * @return
     */
    public List<LogsIp> getLouDou();

    /**
     * 时间
     * @param endDate
     * @return
     */
    public List<LogsIp> getLouDouByDate(@Param("endDate")String endDate);
}
