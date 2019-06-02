package com.ksrs.service;

import com.ksrs.entity.Result;
import java.util.List;


/**
 * Created by Administrator on 2017/10/31 0031.
 */
public interface ResultService {
    public List<Result> getPage(int start,int pagesize);
    public List<Result> getDataByDate(String stardate,String enddate);
    public int getTotal();
    public int getTotalByDate(String stardate,String enddate);
    public List<Result> getGongS(int start,int pagesize);
    public List<Result> getGongSByDate(String endDate);
}
