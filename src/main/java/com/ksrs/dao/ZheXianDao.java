package com.ksrs.dao;

import com.ksrs.entity.LinGan;
import com.ksrs.entity.ZheXian;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
public interface ZheXianDao {
    public ZheXian getdata();

    public ZheXian getComDate(String name);
    public List<LinGan> getsumdata(Map<String,String> map);

}
