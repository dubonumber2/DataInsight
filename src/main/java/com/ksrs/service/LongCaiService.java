package com.ksrs.service;

import com.ksrs.entity.LongCai;

import java.util.List;

public interface LongCaiService {

    /**
     * 结合echarts做折线图
     * @param starDate
     * @param endDate
     * @return
     */
    List<LongCai> getData(String starDate,  String endDate);

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
    List<LongCai> getCzData(String starDate, String endDate);
}
