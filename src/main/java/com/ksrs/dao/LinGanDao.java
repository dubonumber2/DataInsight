package com.ksrs.dao;

import com.ksrs.entity.LinGan;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public interface LinGanDao {
    /**
     * 根据时间来获取数据
     * @param map 时间段
     *  @return 返回
     * */
    public List<LinGan> getByDate(Map<String,String> map);
    /**
     * 根据时间和公司名称
     * @param comName 公司名称
     * @param endDate 截止日期
     * @param starDate 起始日期
     *                 @return fanhui
     * */
    public List<LinGan> getByDateCom(@Param("starDate")String starDate,@Param("endDate")String endDate,@Param("name")String comName );

    /**
     * 默认展示近一周的数据
     * @return
     * */
    public List<LinGan> getData();
    /**
     * 默认展示一周的请求次数
     * @return  返回一个对象封装起来
     * */
    public List<LinGan> getOpenData();

    /**
     * 根据时间
     * @param map
     * @return
     */
    public List<LinGan> getOpenDataByDate(Map<String,String> map);
    /**
     * 默认展示一周的抓取页面数
     * @return  返回一个对象封装起来
     * */
    public List<LinGan> getReqData();

    /**
     * 根据时间展示抓取页面数
     * @param map
     * @return
     */
    public List<LinGan> getReqDataByDate(Map<String,String> map);
    /**
     * 默认展示一周的列表有效抓取页面数
     * @return  返回一个对象封装起来
     * */
    public List<LinGan> getListData();
    /**
     * 默认展示一周的详情有效抓取页面数
     * @return  返回一个对象封装起来
     * */
    public List<LinGan> getDetailData();

    /**
     * 根据用户输入时间查询列表有效抓取页面数
     * @param map
     * @return
     */
     public List<LinGan> getListDataByDate(Map<String,String> map);

    /**
     * 根据用户输入时间查询详情有效抓取页面数
     * @param map
     * @return
     */
    public List<LinGan> getDetailDataByDate(Map<String,String> map);

    /**
     *
     * 得到汇总信息
     * @return
     */
    public List<LinGan> getSumDetailList();

    /**
     * 根据时间得到汇总信息
     * @param map
     * @return
     */
    public List<LinGan> getSumDetailListByDate(Map<String,String> map);
}
