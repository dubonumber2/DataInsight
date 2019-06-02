package com.ksrs.service.impl;

import com.ksrs.dao.ElasticSearchDao;
import com.ksrs.entity.ElasticSearchEntity;
import com.ksrs.service.ElasticSearchService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource("dataSource4")
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Autowired
    private ElasticSearchDao elasticSearchDao;

    public void setElasticSearchDao(ElasticSearchDao elasticSearchDao) {
        this.elasticSearchDao = elasticSearchDao;
    }

    @Override
    public List<ElasticSearchEntity> getNews() {
        return elasticSearchDao.getNews();
    }
}
