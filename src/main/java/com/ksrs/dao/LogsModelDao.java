package com.ksrs.dao;

import com.ksrs.entity.LogsModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
public interface LogsModelDao {
    /**
     * 默认得到前一天的日志统计报表数据
     * @return map
     */
    public List<LogsModel> getDefault(Map<String,Object> map);

    /**
     * 用于分页
     * @param starDate
     * @param endDate
     * @return
     */
    public int getTotal(@Param("starDate") String starDate,@Param("endDate") String endDate);

    /**
     * 根据数据源进行查询
     * @param map
     * @return
     */
    public List<LogsModel> getByName(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public int getByNameTotal(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public List<LogsModel> getByName1(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public List<LogsModel> getJxDefault(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public int getJxDefaultTotal(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public List<LogsModel> getJxDefault1(Map<String,Object> map);
}
