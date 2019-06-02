package com.ksrs.dao;

import com.ksrs.entity.Statistics_zh;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
public interface Statistics_zhDao {
    /**
     * 得到数据
     * @param date
     * @return
     */
    public List<Statistics_zh> getByDate(@Param("date") String date);
}
