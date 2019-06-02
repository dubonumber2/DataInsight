package com.ksrs.dao;

import com.ksrs.entity.Statistics_hz;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
public interface Statistics_hzDao {
    /**
     * 得到汇总表的数据
     * @param endDate
     * @return
     */
    public Statistics_hz getData(String endDate);

    /**
     * 得到汇总表的企业数据
     * @param endDate
     * @return
     */
    public Statistics_hz getQyData(String endDate);
}
