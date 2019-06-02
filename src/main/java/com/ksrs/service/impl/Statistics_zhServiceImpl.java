package com.ksrs.service.impl;

import com.ksrs.dao.Statistics_zhDao;
import com.ksrs.entity.Statistics_zh;
import com.ksrs.service.Statistics_zhService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Service
@DataSource("dataSource4")
public class Statistics_zhServiceImpl implements Statistics_zhService{
    @Autowired
    private Statistics_zhDao statistics_zhDao;

    public void setStatistics_zhDao(Statistics_zhDao statistics_zhDao) {
        this.statistics_zhDao = statistics_zhDao;
    }

    @Override
    public List<Statistics_zh> getByDate(String date) {
        return statistics_zhDao.getByDate(date);
    }
}
