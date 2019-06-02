package com.ksrs.service;

import com.ksrs.entity.ParserView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17 0017.
 */
public interface ParserViewService {
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

    public List<ParserView> getDataByDate(String startDate,String endDate);
    /**
     * 根据时间查询抓取页面数和抓取请求次数
     * @param startDate
     * @param endDate
     * @return
     */
    public List<ParserView> getIpHttpDate( String startDate,  String endDate);
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
    public List<ParserView> getListHttpByDate( String startDate,  String endDate);

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
    public List<ParserView> getDetailHttpByDate(String startDate,String endDate);
}
