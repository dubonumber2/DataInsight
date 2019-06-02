package com.ksrs.service;

import com.ksrs.entity.ElasticSearchEntity;

import java.util.List;

public interface ElasticSearchService {
    /**
     * 得到相关数据
     * @return
     */
    List<ElasticSearchEntity> getNews();
}
