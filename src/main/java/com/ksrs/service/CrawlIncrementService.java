package com.ksrs.service;

import com.ksrs.entity.CrawlIncrement;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface CrawlIncrementService {

    public List<CrawlIncrement> getAll(int pagenum, int pagesize);
    public int getTotal();
    public int getTotalByDate(String start, String end);
    public List<CrawlIncrement> getByDate(String start, String end, int str, int pagesize);
    public List<CrawlIncrement> getDetailByName( String name,  int str, int pagesize);
    public int getTotalDetailByName(String name);
    public List<CrawlIncrement> getByDateName(String name,String start,String end,int str, int pagesize);
    public int getTotalByDateName(String name,String start,String end);

}
