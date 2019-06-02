package com.ksrs.service.impl;

import com.ksrs.dao.User_operationDao;
import com.ksrs.entity.User_operation;
import com.ksrs.service.User_operationService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@DataSource("dataSource4")
public class User_operationServiceImpl implements User_operationService{
    @Autowired
    private User_operationDao user_operationDao;

    public void setUser_operationDao(User_operationDao user_operationDao) {
        this.user_operationDao = user_operationDao;
    }

    @Override
    public List<User_operation> getByOpName(String operation_time,String end_time,String operation_name, String user_name,String user_company,String realname,String user_type, int page, int pageSize) {
        int qs=(page-1)*pageSize;
        Date date = new Date();
        Date yesterday = new Date(date.getTime() - 1*86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = sdf.format(yesterday);
        if(null==operation_time||"".equals(operation_time)){
            operation_time=endDate;
        }
        if(null==end_time||"".equals(end_time)){
            end_time=endDate;
        }
        if("undefined".equals(operation_name)){
            operation_name="";
        }
        if("undefined".equals(user_company)){
            user_company="";
        }
        if("undefined".equals(realname)){
            realname="";
        }
        if("undefined".equals(user_type)){
            user_type="";
        }

        return user_operationDao.getByOpName(operation_time,end_time,operation_name, user_name,user_company,realname,user_type,pageSize, qs);
    }

    @Override
    public List<User_operation> getByDowload(String operation_time,String end_time,String operation_name, String user_name,String user_company,String realname,String user_type) {
        Date date = new Date();
        Date yesterday = new Date(date.getTime() - 1*86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = sdf.format(yesterday);
        if(null==operation_time||"".equals(operation_time)){
            operation_time=endDate;
        }
        if(null==end_time||"".equals(end_time)){
            end_time=endDate;
        }
        if("undefined".equals(user_company)){
            user_company="";
        }
        if("undefined".equals(realname)){
            realname="";
        }
        if("undefined".equals(user_type)){
            user_type="";
        }
        return user_operationDao.getByDowload(operation_time,end_time,operation_name, user_name,user_company,realname,user_type);
    }

    @Override
    public int getTotal(String operation_time,String end_time,String operation_name, String user_name,String user_company,String realname,String user_type) {
        Date date = new Date();
        Date yesterday = new Date(date.getTime() - 1*86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = sdf.format(yesterday);
        if(null==operation_time||"".equals(operation_time)){
            operation_time=endDate;
        }
        if(null==end_time||"".equals(end_time)){
            end_time=endDate;
        }
        if("undefined".equals(user_company)){
            user_company="";
        }
        if("undefined".equals(realname)){
            realname="";
        }
        if("undefined".equals(operation_name)){
            operation_name="";
        }
        if("undefined".equals(user_type)){
            user_type="";
        }
        return user_operationDao.getTotal(operation_time,end_time,operation_name,user_name,user_company,realname,user_type);
    }

    @Override
    public List<User_operation> getSum(String user_company) {
        if("undefined".equals(user_company)){
            user_company="";
        }
        return user_operationDao.getSum(user_company);
    }

    @Override
    public void insertUser(User_operation user_operation) {
        user_operationDao.insertUser(user_operation);
    }

    @Override
    public List<User_operation> getUser(int pageSize, int page) {
        int limit=(page-1)*pageSize;
        Map<String,Integer> map=new HashMap<>();
        map.put("pageSize",pageSize);
        map.put("page",limit);
        return user_operationDao.getUser(map);
    }

    @Override
    public int getUserTotal() {
        return user_operationDao.getUserTotal();
    }
}
