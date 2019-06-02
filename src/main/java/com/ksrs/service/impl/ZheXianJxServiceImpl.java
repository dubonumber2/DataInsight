package com.ksrs.service.impl;

import com.ksrs.dao.ZheXianJxDao;
import com.ksrs.entity.ZheXianJx;
import com.ksrs.service.ZheXianJxService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
@Service
@DataSource("dataSource")
public class ZheXianJxServiceImpl implements ZheXianJxService {
    @Autowired
    ZheXianJxDao zheXianJxDao;

    public void setZheXianJxDao(ZheXianJxDao zheXianJxDao) {
        this.zheXianJxDao = zheXianJxDao;
    }

    @Override
    public ZheXianJx getDate() {
        return zheXianJxDao.getDate();
    }

    @Override
    public ZheXianJx getDateByName(String name) {
        return zheXianJxDao.getDateByName(name);
    }
}
