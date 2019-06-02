package com.ksrs.service.impl;

import com.ksrs.dao.ZheXianDao;
import com.ksrs.entity.LinGan;
import com.ksrs.entity.ZheXian;
import com.ksrs.service.ZheXianService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Service
@DataSource("dataSource")
public class ZheXianServieImpl implements ZheXianService {
    @Autowired
    private ZheXianDao zheXianDao;
    @Override
    public ZheXian getdata() {
        return zheXianDao.getdata();
    }

    public void setZheXianDao(ZheXianDao zheXianDao) {
        this.zheXianDao = zheXianDao;
    }


    @Override
    public ZheXian getComDate(String name) {
        return  zheXianDao.getComDate(name);
    }

    @Override
    public List<LinGan> getsumdata(String startDate, String endDate) {
        Map<String,String> map=new HashMap<>(1);
        map.put("starDate",startDate);
        map.put("endDate",endDate);

        return zheXianDao.getsumdata(map);
    }
}
