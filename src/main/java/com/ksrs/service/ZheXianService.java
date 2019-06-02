package com.ksrs.service;

import com.ksrs.entity.LinGan;
import com.ksrs.entity.ZheXian;

import java.util.List;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
public interface ZheXianService {
    public ZheXian getdata();

    public ZheXian getComDate(String name);

    public List<LinGan> getsumdata(String startDate,String endDate);

}
