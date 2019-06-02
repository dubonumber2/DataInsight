package com.ksrs.dao;

import com.ksrs.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
public interface ResultDao {
    public List<Result> getPage(Map<String,Integer> map);
    public List<Result> getDataByDate(Map<String,String> map);
    public int getTotal();
    public int getTotalByDate(Map<String,String> map);
    public List<Result> getGongS(Map<String,Integer> map);
    public List<Result> getGongSByDate(@Param("enddate") String endDate);

}
