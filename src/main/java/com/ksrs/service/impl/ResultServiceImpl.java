package com.ksrs.service.impl;

import com.ksrs.dao.ResultDao;
import com.ksrs.entity.Result;
import com.ksrs.service.ResultService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@Service
@DataSource("dataSource4")
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultDao resultDao;

    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }
    @Override
    public List<Result> getPage(int start, int pagesize) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        int a=(start-1)*pagesize;
        map.put("start",a);
        map.put("pagesize",pagesize);
        return resultDao.getPage(map);
    }
    @Override
    public int getTotal() {
        return resultDao.getTotal();
    }

    @Override
    public List<Result> getDataByDate(String stardate, String enddate) {
        Map<String,String> map=new HashMap<String,String>(5);
        map.put("stardate",stardate);
        map.put("enddate",enddate);
        return resultDao.getDataByDate(map);
    }

    @Override
    public int getTotalByDate(String stardate, String enddate) {
        Map<String,String> map=new HashMap<String,String>(5);
        map.put("stardate",stardate);
        map.put("enddate",enddate);
        return resultDao.getTotalByDate(map);
    }

    @Override
    public List<Result> getGongS(int start, int pagesize) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        int a=(start-1)*pagesize;
        map.put("start",a);
        map.put("pagesize",pagesize);
        return resultDao.getGongS(map);
    }

    @Override
    public List<Result> getGongSByDate(String endDate) {
        return resultDao.getGongSByDate(endDate);
    }
}
