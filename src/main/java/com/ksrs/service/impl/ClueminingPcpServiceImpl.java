package com.ksrs.service.impl;

import com.ksrs.dao.ClueminingPcpDao;
import com.ksrs.entity.User_operation;
import com.ksrs.service.ClueminingPcpService;
import com.ksrs.utils.DataSource;
import com.ksrs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource("dataSource4")
public class ClueminingPcpServiceImpl implements ClueminingPcpService {

    @Autowired
    private ClueminingPcpDao clueminingPcpDao;

    @Override
    public List<User_operation> getByOpName(String operation_time, String end_time, String operation_name, String user_name, String user_company, String realname, String user_type, int page, int pageSize) {

        //int total = clueminingPcpDao.getTotal(operation_time, end_time, operation_name, user_name, user_company, realname, user_type);
        int startSize = pageSize*(page-1);
        String endDate = DateUtils.getYesterDay();
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
        if("undefined".equals(user_type)) {
            user_type = "";
        }
        return clueminingPcpDao.getByOpName(operation_time, end_time, operation_name, user_name, user_company, realname, user_type, pageSize, startSize);
    }

    @Override
    public List<User_operation> getByDowload(String operation_time, String end_time, String operation_name, String user_name, String user_company, String realname, String user_type) {
        return null;
    }

    @Override
    public int getTotal(String operation_time, String end_time, String operation_name, String user_name, String user_company, String realname, String user_type) {
        String endDate = DateUtils.getYesterDay();
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
        if("undefined".equals(user_type)) {
            user_type = "";
        }
        return clueminingPcpDao.getTotal(operation_time, end_time, operation_name, user_name, user_company, realname, user_type);
    }

    @Override
    public List<User_operation> getSum(String user_company) {
        return null;
    }

    @Override
    public void insertUser(User_operation user_operation) {

    }

    @Override
    public List<User_operation> getUser(int pageSize, int page) {
        return null;
    }

    @Override
    public int getUserTotal() {
        return 0;
    }
}
