package com.ksrs.service.impl;

import com.ksrs.dao.CrawlIncrementDao;
import com.ksrs.entity.CrawlIncrement;
import com.ksrs.service.CrawlIncrementService;

import com.ksrs.utils.DataSource;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
@Service
@DataSource("dataSource")
public class CrawlIncrementServiceImpl implements CrawlIncrementService {
    @Autowired
    CrawlIncrementDao crawlIncrementDao;

    //获得按时间段查询的总条数
    @Override
    public int getTotalByDate(String start, String end) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("start",start);map.put("end",end);

        return crawlIncrementDao.getTotalByDate(map);
    }
    //获得按时间段查询的数据
    @Override
    public List<CrawlIncrement> getByDate(String start, String end, int pagenum, int pagesize) {


      int str=(pagenum-1)*pagesize;
        return crawlIncrementDao.getByDate(start,end,str,pagesize);
    }

    @Override
    public List<CrawlIncrement> getAll(int pagenum, int pagesize) {

        Map<String,Integer> map=new HashMap<String, Integer>();
        int start=(pagenum-1)*pagesize;
        map.put("start",start);
        map.put("pagesize",pagesize);
        List<CrawlIncrement> list=crawlIncrementDao.getAll(map);
        return list;
    }

    @Override
    public int getTotal() {
        return crawlIncrementDao.getTotal();
    }


    @Override
    public List<CrawlIncrement> getDetailByName(String name, int pagenum, int pagesize) {
        int str=(pagenum-1)*pagesize;
        return crawlIncrementDao.getDetailByName(name,str,pagesize);
    }

    @Override
    public int getTotalDetailByName(String name) {
        return crawlIncrementDao.getTotalDetailByName(name);
    }

    @Override
    public List<CrawlIncrement> getByDateName(String name, String start, String end, int pagenum, int pagesize) {
        int str=(pagenum-1)*pagesize;
        return crawlIncrementDao.getByDateName(name,start,end,str,pagesize);
    }

    @Override
    public int getTotalByDateName( String name, String start, String end) {
        return crawlIncrementDao.getTotalByDateName(name,start,end);
    }


    public void setCrawlIncrementDao(CrawlIncrementDao crawlIncrementDao) {
        this.crawlIncrementDao = crawlIncrementDao;
    }
}
