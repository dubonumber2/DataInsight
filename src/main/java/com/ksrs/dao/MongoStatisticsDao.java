package com.ksrs.dao;

import com.ksrs.entity.MongoStatistics;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
public interface MongoStatisticsDao {
    /**
     * 得到自动迁移的映射关系
     * @return
     */
    public List<MongoStatistics> getAll();

    /**
     * 添加数据
     * @param mongoStatistics
     */
    public void insertData(MongoStatistics mongoStatistics);
}
