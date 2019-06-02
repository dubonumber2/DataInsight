package com.ksrs.service;

import com.ksrs.entity.LogsModel;

import java.util.List;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
public interface LogsModelService {
    /**
     * 默认得到前一天的日志统计报表数据
     * @return map
     */
    public List<LogsModel> getDefault(int page,int pageSize,String starDate,String endDate);
    /**
     * 用于分页
     * @param starDate
     * @param endDate
     * @return
     */
    public int getTotal(String starDate,String endDate);

    /**
     *
     * @param starDate
     * @param endDate
     * @param comName
     * @param page
     * @param pageSize
     * @return
     */
    public List<LogsModel> getByName(String starDate,String endDate,String comName,int page,int pageSize);

    /**
     *
     * @param starDate
     * @param endDate
     * @param comName
     * @return
     */
    public int getByNameTotal(String starDate,String endDate,String comName);

    /**
     *
     * @param starDate
     * @param endDate
     * @param comName
     * @return
     */
    public List<LogsModel> getByName1(String starDate,String endDate,String comName);

    /**
     *
     * @param starDate
     * @param endDate
     * @param page
     * @param pageSize
     * @return
     */
    public List<LogsModel> getJxDefault(String starDate,String endDate,int page,int pageSize,String comName);

    /**
     *
     * @param starDate
     * @param endDate
     * @return
     */
    public int getJxDefaultTotal(String starDate,String endDate,String comName);

    /**
     *
     * @param starDate
     * @param endDate
     * @param comName
     * @return
     */
    public List<LogsModel> getJxDefault1(String starDate,String endDate,String comName);
}
