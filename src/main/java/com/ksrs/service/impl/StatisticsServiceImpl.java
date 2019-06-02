package com.ksrs.service.impl;

import com.ksrs.dao.StatisticsDao;
import com.ksrs.entity.Statistics;
import com.ksrs.service.StatisticsServie;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
@Service
@DataSource("dataSource")
public class StatisticsServiceImpl implements StatisticsServie {

    @Autowired
    StatisticsDao statisticsDao;

    @Override
    public List<Statistics> getAll(int pagenum, int pagesize) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("start",(pagenum-1)*pagesize);
        map.put("pagesize",pagesize);
        return statisticsDao.getPage(map);
    }

    @Override
    public int getTotal() {
        return statisticsDao.getTotal();
    }

    public void setStatisticsDao(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }
}
