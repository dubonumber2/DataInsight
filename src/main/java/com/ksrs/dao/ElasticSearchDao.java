package com.ksrs.dao;

import com.ksrs.entity.ElasticSearchEntity;

import java.util.List;

public interface ElasticSearchDao {
    /**
     * 得到相关数据
     * @return
     */
    List<ElasticSearchEntity> getNews();
}
