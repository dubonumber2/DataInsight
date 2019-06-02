package com.ksrs.service.impl;

import com.ksrs.dao.QggsZlDao;
import com.ksrs.entity.QggsZl;
import com.ksrs.service.QggsZlService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Service
@DataSource("dataSource4")
public class QggsZlServiceImpl implements QggsZlService{
    @Autowired
    QggsZlDao qggsZlDao;

    public void setQggsZlDao(QggsZlDao qggsZlDao) {
        this.qggsZlDao = qggsZlDao;
    }

    @Override
    public List<QggsZl> getDataByDate(String endDate) {
        return qggsZlDao.getDataByDate(endDate);
    }

    @Override
    public List<QggsZl> getJyzData(String endDate) {
        return qggsZlDao.getJyzData(endDate);
    }

    @Override
    public List<QggsZl> getFzcData(String endDate) {
        return qggsZlDao.getFzcData(endDate);
    }

    @Override
    public List<QggsZl> getQtData(String endDate) {
        return qggsZlDao.getQtData(endDate);
    }
}
