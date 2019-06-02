package com.ksrs.service;

import com.ksrs.entity.Statistics;

import java.util.List;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface StatisticsServie  {

    public List<Statistics> getAll(int pagenum, int pagesize);

    public int getTotal();
}
