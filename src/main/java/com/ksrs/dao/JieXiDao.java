package com.ksrs.dao;

import com.ksrs.entity.JieXi;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public interface JieXiDao {
    public List<JieXi> getDate(@Param("date") String date,@Param("start") int start,@Param("pagesize") int pagesize);
    public int getTotalByDate(String date);
    public List<JieXi> getData(Map<String,Integer> map);
    public int getTotal();
    public long getSumByDate(String date);
}
