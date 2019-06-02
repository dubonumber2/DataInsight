package com.ksrs.service.impl;

import com.ksrs.dao.LogsIpDao;
import com.ksrs.entity.LogsIp;
import com.ksrs.service.LogsIpService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
@Service
@DataSource("dataSource4")
public class LogsIpServiceImpl implements LogsIpService{
    @Autowired
    LogsIpDao logsIpDao;

    public void setLogsIpDao(LogsIpDao logsIpDao) {
        this.logsIpDao = logsIpDao;
    }

    @Override
    public List<LogsIp> getIpSendHttp() {
        return logsIpDao.getIpSendHttp();
    }

    @Override
    public List<LogsIp> getSaotu() {
        return logsIpDao.getSaotu();
    }

    @Override
    public List<LogsIp> getLouDou() {
        return logsIpDao.getLouDou();
    }

    @Override
    public List<LogsIp> getLouDouByDate(String endDate) {
        return logsIpDao.getLouDouByDate(endDate);
    }
}
