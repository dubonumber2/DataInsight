package com.ksrs.dao;

import com.ksrs.entity.CrawlIncrement;

import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public interface CrawlIncrementDao {
    /**
     * 得到所有
     * @return
     */

    public List<CrawlIncrement> getAll(Map<String, Integer> map);
    /**
     * 得到查询条数
     * @return
     */
    public int getTotal();
    /**
     * 得到所有
     * @return
     * @param start 查询的起始日期
     * @param end 查询的结束日期
     * @param str 分页
     * @param pagesize 条数
     */
    public List<CrawlIncrement> getByDate(@Param("start") String start, @Param("end") String end, @Param("str") int str, @Param("pagesize") int pagesize);
    /**
     * 得到所有
     * @return
     * @param map
     */
    public int getTotalByDate(Map<String, String> map);
    /**
     * 得到所有
     * @return
     * @param pagesize
     * @param name
     * @param str
     */
    public List<CrawlIncrement> getDetailByName(@Param("name") String name,@Param("str") int str,@Param("pagesize") int pagesize);
    /**
     * 得到所有
     * @return
     * @param name
     */
    public int getTotalDetailByName(String name);
    /**
     * 得到所有
     * @return
     * @param str
     * @param name
     * @param pagesize
     * @param end
     * @param start
     */
    public List<CrawlIncrement> getByDateName(@Param("name") String name,@Param("start") String start,@Param("end") String end,@Param("str") int str,@Param("pagesize") int pagesize);
    /**
     * 得到所有
     * @return
     * @param end
     * @param start
     * @param name
     *
     */
    public int getTotalByDateName(@Param("name") String name,@Param("start") String start,@Param("end") String end);

}
