package com.ksrs.dao;

import com.ksrs.entity.ParserView;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Administrator on 2017/11/17 0017.
 */
public interface ParserViewDao {
    /**
     * 得到数据 echarts展示
     * @return
     */
    public List<ParserView> getData();

    /**
     * 根据时间
     * @param startDate
     * @param endDate
     * @return
     */

     public List<ParserView> getDataByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 根据时间查询抓取页面数和抓取请求次数
     * @param startDate
     * @param endDate
     * @return
     */
    public List<ParserView> getIpHttpDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 查询抓取页面数和抓取请求次数(近一周)
     * @return
     */
    public List<ParserView> getIpHttp();

    /**
     * 得到列表的请求次数
     * @return
     */
    public List<ParserView> getListHttp();

    /**
     * 根据时间得到列表的请求次数
     * @param startDate
     * @param endDate
     * @return
     */
    public List<ParserView> getListHttpByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 得到详情的请求次数
     * @return
     */
    public List<ParserView> getDetailHttp();

    /**
     * 根据时间
     * @param startDate
     * @param endDate
     * @return
     */
    public List<ParserView> getDetailHttpByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);


}
