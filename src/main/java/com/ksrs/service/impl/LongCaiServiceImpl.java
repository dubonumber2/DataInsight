package com.ksrs.service.impl;

import com.ksrs.dao.LongCaiDao;
import com.ksrs.entity.LongCai;
import com.ksrs.service.LongCaiService;
import com.ksrs.utils.DataSource;
import com.ksrs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource("dataSource4")
public class LongCaiServiceImpl implements LongCaiService {
    @Autowired
    private LongCaiDao longCaiDao;

    @Override
    public List<LongCai> getData(String starDate, String endDate) {
        if("undefined".equals(starDate)||starDate==null){
            starDate= DateUtils.getAgoDay();
        }
        if("undefined".equals(endDate)||endDate==null){
            endDate=DateUtils.getYesterDay();
        }
        return longCaiDao.getData(starDate, endDate);
    }

    @Override
    public LongCai getOne() {
        return longCaiDao.getOne();
    }

    @Override
    public List<LongCai> getCzData(String starDate, String endDate) {
        if("undefined".equals(starDate)||starDate==null){
            starDate= DateUtils.getAgoDay();
        }
        if("undefined".equals(endDate)||endDate==null){
            endDate=DateUtils.getYesterDay();
        }
        return longCaiDao.getCzData(starDate, endDate);
    }
}
