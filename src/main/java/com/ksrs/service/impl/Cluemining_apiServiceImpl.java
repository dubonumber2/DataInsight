package com.ksrs.service.impl;

import com.ksrs.dao.Cluemining_apiDao;
import com.ksrs.entity.ClueminingApiExpand;
import com.ksrs.entity.Cluemining_api;
import com.ksrs.service.Cluemining_apiService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource("dataSource4")
public class Cluemining_apiServiceImpl implements Cluemining_apiService {
    @Autowired
    private Cluemining_apiDao cluemining_apiDao;

    public void setCluemining_apiDao(Cluemining_apiDao cluemining_apiDao) {
        this.cluemining_apiDao = cluemining_apiDao;
    }

    @Override
    public List<Cluemining_api> getData(String starDate, String endDate, String operation_explain,String operation_type,int page, int pageSize) {
        if("undefined".equals(starDate)){
            starDate="";
        }else if("undefined".equals(endDate)){
            endDate="";
        }else if("undefined".equals(operation_explain)){
            operation_explain="";
        }else if("undefined".equals(operation_type)){
            operation_type="";
        }
        int pageSize1=(page-1)*pageSize;
       // System.out.println(starDate+"|"+endDate+"|"+operation_explain+"|"+pageSize1+"|"+pageSize);
        return cluemining_apiDao.getData(starDate, endDate, operation_explain,operation_type,pageSize, pageSize1);
    }

    @Override
    public int getTotal(String starDate, String endDate, String operation_explain,String operation_type) {
        if("undefined".equals(starDate)){
            starDate="";
        }else if("undefined".equals(endDate)){
            endDate="";
        }else if("undefined".equals(operation_explain)){
            operation_explain="";
        }else if("undefined".equals(operation_type)){
            operation_type="";
        }
        return cluemining_apiDao.getTotal(starDate, endDate, operation_explain,operation_type
        );
    }

    @Override
    public List<ClueminingApiExpand> getPage(int page, int limit, String ip) {
        if("undefined".equals(ip)){
            ip = "";
        }
        int pageSize = (page-1)*limit;
        return cluemining_apiDao.getPage(pageSize,limit,ip);
    }

    @Override
    public Integer getExpandTotal(String ip) {
        if("undefined".equals(ip)){
            ip = "";
        }
        return cluemining_apiDao.getExpandTotal(ip);
    }
}
