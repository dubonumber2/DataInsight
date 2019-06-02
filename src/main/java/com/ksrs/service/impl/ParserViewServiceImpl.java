package com.ksrs.service.impl;

import com.ksrs.dao.ParserViewDao;
import com.ksrs.entity.ParserView;
import com.ksrs.service.ParserViewService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17 0017.
 */
@Service
@DataSource("dataSource4")
public class ParserViewServiceImpl implements ParserViewService {
    @Autowired
    ParserViewDao parserViewDao;

    public void setParserViewDao(ParserViewDao parserViewDao) {
        this.parserViewDao = parserViewDao;
    }

    @Override
    public List<ParserView> getData() {
        return parserViewDao.getData();
    }

    @Override
    public List<ParserView> getDataByDate(String startDate, String endDate) {
        return parserViewDao.getDataByDate(startDate,endDate);
    }

    @Override
    public List<ParserView> getIpHttpDate(String startDate, String endDate) {
        return parserViewDao.getIpHttpDate(startDate, endDate);
    }

    @Override
    public List<ParserView> getIpHttp() {
        return parserViewDao.getIpHttp();
    }

    @Override
    public List<ParserView> getListHttp() {
        return parserViewDao.getListHttp();
    }

    @Override
    public List<ParserView> getListHttpByDate(String startDate, String endDate) {
        return parserViewDao.getListHttpByDate(startDate, endDate);
    }

    @Override
    public List<ParserView> getDetailHttp() {
        return parserViewDao.getDetailHttp();
    }

    @Override
    public List<ParserView> getDetailHttpByDate(String startDate, String endDate) {
        return parserViewDao.getDetailHttpByDate(startDate, endDate);
    }
}
