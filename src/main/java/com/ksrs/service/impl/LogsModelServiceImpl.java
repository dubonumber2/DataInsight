package com.ksrs.service.impl;

import com.ksrs.dao.LogsModelDao;
import com.ksrs.entity.LogsModel;
import com.ksrs.service.LogsModelService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/12/16 0016.
 */
@Service
@DataSource("dataSource4")
public class LogsModelServiceImpl implements LogsModelService {
    @Autowired
    private LogsModelDao logsModelDao;

    public void setLogsModelDao(LogsModelDao logsModelDao) {
        this.logsModelDao = logsModelDao;
    }

    @Override
    public List<LogsModel> getDefault(int page, int pageSize,String starDate,String endDate) {
        Map<String,Object> map=new HashMap<>(1);
        map.put("pageSize",pageSize);
        map.put("start",(page-1)*pageSize);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        return logsModelDao.getDefault(map);
    }

    @Override
    public int getTotal(String starDate,String endDate) {
        return logsModelDao.getTotal(starDate,endDate);
    }

    @Override
    public List<LogsModel> getByName(String starDate, String endDate, String comName, int page, int pageSize) {
        Map<String,Object> map=new HashMap<>(10);
        map.put("pageSize",pageSize);
        map.put("start",(page-1)*pageSize);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getByName(map);
    }

    @Override
    public int getByNameTotal(String starDate, String endDate, String comName) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getByNameTotal(map);
    }

    @Override
    public List<LogsModel> getByName1(String starDate, String endDate, String comName) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getByName1(map);
    }


    @Override
    public List<LogsModel> getJxDefault(String starDate, String endDate, int page, int pageSize, String comName) {
        Map<String,Object> map=new HashMap<>(10);
        map.put("pageSize",pageSize);
        map.put("start",(page-1)*pageSize);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getJxDefault(map);
    }

    @Override
    public int getJxDefaultTotal(String starDate, String endDate, String comName) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getJxDefaultTotal(map);
    }

    @Override
    public List<LogsModel> getJxDefault1(String starDate, String endDate, String comName) {
        Map<String,Object> map=new HashMap<>(3);
        map.put("endDate",endDate);
        map.put("starDate",starDate);
        map.put("comName",comName);
        return logsModelDao.getJxDefault1(map);
    }
}
