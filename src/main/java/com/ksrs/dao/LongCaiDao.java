package com.ksrs.dao;

import com.ksrs.entity.LongCai;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 龙采使用报告的接口
 */
public interface LongCaiDao {
    /**
     * 结合echarts做折线图
     * @param starDate
     * @param endDate
     * @return
     */
    List<LongCai> getData(@Param("starDate")String starDate,@Param("endDate") String endDate);

    /**
     * 得到昨天的信息用于展示详情
     * @return
     */
    LongCai getOne();

    /**
     * 常州的折线图
     * @param starDate
     * @param endDate
     * @return
     */
    List<LongCai> getCzData(@Param("starDate")String starDate,@Param("endDate") String endDate);

}
