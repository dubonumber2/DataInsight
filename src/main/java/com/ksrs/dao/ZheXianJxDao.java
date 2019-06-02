package com.ksrs.dao;

import com.ksrs.entity.ZheXian;
import com.ksrs.entity.ZheXianJx;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
public interface ZheXianJxDao {
    public ZheXianJx getDate();
    public ZheXianJx getDateByName(String name);
}
