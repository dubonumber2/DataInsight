package com.ksrs.service.impl;

import com.ksrs.dao.Statistics_hzDao;
import com.ksrs.entity.Statistics_hz;
import com.ksrs.service.Statistics_hzService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
@DataSource("dataSource4")
@Service
public class Statistics_hzServiceImpl implements Statistics_hzService{
    @Autowired
    Statistics_hzDao statistics_hzDao;

    public void setStatistics_hzDao(Statistics_hzDao statistics_hzDao) {
        this.statistics_hzDao = statistics_hzDao;
    }

    @Override
    public Statistics_hz getData(String endDate) {
        return statistics_hzDao.getData(endDate);
    }

    @Override
    public Statistics_hz getQyData(String endDate) {
        return statistics_hzDao.getQyData(endDate);
    }
}
