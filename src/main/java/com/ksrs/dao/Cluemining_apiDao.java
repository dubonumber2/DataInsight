package com.ksrs.dao;

import com.ksrs.entity.ClueminingApiExpand;
import com.ksrs.entity.Cluemining_api;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Cluemining_apiDao {
    /**
     * 通过组合查询得到产品api的调用情况
     * @param starDate
     * @param endDate
     * @param operation_explain
     * @param page
     * @param pageSize
     * @return
     */
    public List<Cluemining_api> getData(@Param("starDate") String starDate, @Param("endDate")String endDate, @Param("operation_explain")String operation_explain,@Param("operation_type")String operation_type, @Param("page")int page, @Param("pageSize") int pageSize);

    /**
     * 得到查询结果的条数，用于分页
     * @param starDate
     * @param endDate
     * @param operation_explain
     * @return
     */
    public int getTotal(@Param("starDate") String starDate, @Param("endDate")String endDate, @Param("operation_explain")String operation_explain,@Param("operation_type")String operation_type);

    List<ClueminingApiExpand> getPage(@Param("pageSize")int pageSize,@Param("limit")int limit,@Param("ip")String ip);

    Integer getExpandTotal(@Param("ip") String ip);
}
