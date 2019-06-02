package com.ksrs.service;

import com.ksrs.entity.JieXi;


import java.util.List;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public interface JieXiService {
    public List<JieXi> getDate(String date, int start,  int pagesize);
    public int getTotalByDate(String date);
    public List<JieXi> getData(int start,int pagesize);
    public int getTotal();
    public long getSumByDate(String date);
}
