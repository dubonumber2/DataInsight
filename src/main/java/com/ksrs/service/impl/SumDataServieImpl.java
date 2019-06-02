package com.ksrs.service.impl;

import com.ksrs.dao.SumDataDao;
import com.ksrs.entity.SumData;
import com.ksrs.service.SumDataService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Service
@DataSource("dataSource")
public class SumDataServieImpl implements SumDataService {
    @Autowired
    private SumDataDao sumDataDao;
    @Override
    public SumData getdata() {
        return sumDataDao.getdata();
    }

    public void setSumDataDao(SumDataDao sumDataDao) {
        this.sumDataDao = sumDataDao;
    }
}
