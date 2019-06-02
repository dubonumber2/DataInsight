package com.ksrs.service.impl;

import com.ksrs.dao.MongoStatisticsDao;
import com.ksrs.entity.MongoStatistics;
import com.ksrs.service.MongoStatisticsService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Service
@DataSource("dataSource4")
public class MongoStatisticsServiceImpl implements MongoStatisticsService {
    @Autowired
    private MongoStatisticsDao mongoStatisticsDao;

    public void setMongoStatisticsDao(MongoStatisticsDao mongoStatisticsDao) {
        this.mongoStatisticsDao = mongoStatisticsDao;
    }

    @Override
    public List<MongoStatistics> getAll() {
        return mongoStatisticsDao.getAll();
    }

    @Override
    public void insertData(MongoStatistics mongoStatistics) {
        mongoStatisticsDao.insertData(mongoStatistics);
    }
}
