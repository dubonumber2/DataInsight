package com.ksrs.service.impl;

import com.ksrs.dao.Crawl_typeDao;
import com.ksrs.entity.Crawl_type;
import com.ksrs.service.Crawl_typeService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Service
@DataSource("dataSource")
public class Crawl_typeServiceImpl implements Crawl_typeService {
    @Autowired
    private Crawl_typeDao crawl_typeDao;

    public void setCrawl_typeDao(Crawl_typeDao crawl_typeDao) {
        this.crawl_typeDao = crawl_typeDao;
    }

    @Override
    public List<Crawl_type> getAll() {
        return crawl_typeDao.getAll();
    }
}
