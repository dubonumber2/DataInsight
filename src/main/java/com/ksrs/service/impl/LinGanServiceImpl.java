package com.ksrs.service.impl;

import com.ksrs.dao.LinGanDao;
import com.ksrs.entity.LinGan;
import com.ksrs.service.LinGanService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Service
@DataSource("dataSource")
public class LinGanServiceImpl implements LinGanService{
    @Autowired
    LinGanDao linGanDao;

    public void setLinGanDao(LinGanDao linGanDao) {
        this.linGanDao = linGanDao;
    }

    @Override
    public List<LinGan> getByDate(String starDate, String endDate) {
        Map<String,String> map=new HashMap<String,String>(5);
        map.put("starDate",starDate);
        map.put("endDate",endDate);
        return linGanDao.getByDate(map);
    }

    @Override
    public List<LinGan> getByDateCom(String starDate, String endDate, String comName) {
        return linGanDao.getByDateCom(starDate, endDate, comName);
    }

    @Override
    public List<LinGan> getData() {
        return linGanDao.getData();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getOpenData() {
        return linGanDao.getOpenData();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getReqData() {
        return linGanDao.getReqData();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getListData() {
        return linGanDao.getListData();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getDetailData() {
        return linGanDao.getDetailData();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getListDataByDate(String startDate, String endDate) {
        Map<String,String> map=new HashMap<>(1);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return linGanDao.getListDataByDate(map);
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getDetailDataByDate(String startDate, String endDate) {
        Map<String,String> map=new HashMap<>(1);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return linGanDao.getDetailDataByDate(map);
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getOpenDataByDate(String startDate, String endDate) {
        Map<String,String> map=new HashMap<>(1);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return linGanDao.getOpenDataByDate(map);
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getReqDataByDate(String startDate, String endDate) {
        Map<String,String> map=new HashMap<>(1);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return linGanDao.getReqDataByDate(map);
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getSumDetailList() {
        return linGanDao.getSumDetailList();
    }

    @Override
    @DataSource("dataSource4")
    public List<LinGan> getSumDetailListByDate(String startDate, String endDate) {

        Map<String,String> map=new HashMap<>(1);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        return linGanDao.getSumDetailListByDate(map);
    }
}
