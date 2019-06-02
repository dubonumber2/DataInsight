package com.ksrs.service.impl;

import com.ksrs.dao.JieXiDao;
import com.ksrs.entity.JieXi;
import com.ksrs.service.JieXiService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
@Service
@DataSource("dataSource")
public class JieXiServiceImpl implements JieXiService {
    @Autowired
    JieXiDao jieXiDao;
    @Override
    public List<JieXi> getDate(String date,int start,int pagesize) {

        int aa=(start-1)*pagesize;

        return jieXiDao.getDate(date,aa,pagesize);
    }

    public void setJieXiDao(JieXiDao jieXiDao) {
        this.jieXiDao = jieXiDao;
    }

    @Override
    public List<JieXi> getData(int start, int pagesize) {
        int pageno=(start-1)*pagesize;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("start",pageno);map.put("pagesize",pagesize);
        return jieXiDao.getData(map);
    }

    @Override
    public int getTotal() {
        return jieXiDao.getTotal();
    }

    @Override
    public int getTotalByDate(String date) {
        return jieXiDao.getTotalByDate(date);
    }

    @Override
    public long getSumByDate(String date) {
        return jieXiDao.getSumByDate(date);
    }
}
