package com.ksrs.service;

import com.ksrs.entity.QggsZl;

import java.util.List;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
public interface QggsZlService {
    /**
     * 根据时间得到全国工商统计总量的数据
     * @param endDate
     * @return
     */
    public List<QggsZl> getDataByDate(String endDate);

    /**
     * 根据时间得到经营中的数据
     * @param endDate
     * @return
     */
    public List<QggsZl> getJyzData(String endDate);
    /**
     * 得到非正常经营的数据
     * @param endDate
     * @return
     */
    public List<QggsZl> getFzcData(String endDate);
    /**
     * 得到未知(其它)经营状态的量
     * @param endDate
     * @return
     */
    public List<QggsZl> getQtData(String endDate);
}
