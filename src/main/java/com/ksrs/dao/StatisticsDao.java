package com.ksrs.dao;

import com.ksrs.entity.Statistics;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface StatisticsDao {

    public List<Statistics> getPage(Map<String, Integer> map);

    public int getTotal();


}
