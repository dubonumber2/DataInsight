package com.ksrs.service;

import com.ksrs.entity.Statistics_zh;


import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface Statistics_zhService {
    /**
     * 得到数据
     * @param date
     * @return
     */
    public List<Statistics_zh> getByDate( String date);
}
