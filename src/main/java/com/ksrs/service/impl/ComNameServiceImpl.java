package com.ksrs.service.impl;

import com.ksrs.dao.ComNameDao;
import com.ksrs.entity.ComName;
import com.ksrs.entity.ZqDataSource;
import com.ksrs.service.ComNameService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
@Service
@DataSource("dataSource")
public class ComNameServiceImpl implements ComNameService {
    @Autowired
    ComNameDao comNameDao;
    @Override
    public List<ComName> getAllName() {
        return comNameDao.getAllName();
    }

    public void setComNameDao(ComNameDao comNameDao) {
        this.comNameDao = comNameDao;
    }

    @Override
    public List<ComName> getJxName() {
        return comNameDao.getJxName();
    }

    @Override
    @DataSource("dataSource4")
    public List<ComName> getDataSource(String describe) {
        return comNameDao.getDataSource(describe);
    }

    @Override
    @DataSource("dataSource4")
    public List<ComName> getJxSource() {
        return comNameDao.getJxSource();
    }

    @Override
    @DataSource("dataSource4")
    @Transactional
    public void insertDataSource(ZqDataSource ZqDataSource) {

        comNameDao.insertDataSource(ZqDataSource);
    }

    @Override
    @DataSource("dataSource4")
    public void insertJxDataSource(String dataSource, String describe) {
        Map<String,String> map=new HashMap<>(2);
        map.put("dataSource",dataSource);
        map.put("describe",describe);
        comNameDao.insertJxDataSource(map);
    }

    @Override
    @DataSource("dataSource4")
    public List<ComName> getClueminCompany() {
        return comNameDao.getClueminCompany();
    }

    @Override
    @DataSource("dataSource4")
    public void updateData(ZqDataSource zqDataSource) {
        comNameDao.updateData(zqDataSource);
    }

    @Override
    @DataSource("dataSource4")
    public List<ComName> getPcpName() {
        return comNameDao.getPcpName();
    }
}
