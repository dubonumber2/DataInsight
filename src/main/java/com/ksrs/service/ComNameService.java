package com.ksrs.service;

import com.ksrs.entity.ComName;
import com.ksrs.entity.ZqDataSource;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public interface ComNameService {
    /**
     * 得到所有公司名称
     * @return 名字列表
     */
    public List<ComName> getAllName();
    /**
     * 得到所有公司名称
     * @return 名字列表
     */
    public List<ComName> getJxName();
    /**
     * 得到日志中的数据源
     * @return
     */
    public List<ComName> getDataSource(String describe);

    /**
     * 得到解析的数据源
     * @return
     */
    public List<ComName> getJxSource();

    /**
     *
     * @param ZqDataSource
     */
    public void insertDataSource(ZqDataSource ZqDataSource);

    /**
     * 解析数据字典的维护
     * @param dataSource
     * @param describe
     */
    public void insertJxDataSource(String dataSource,String describe);
    /**
     *得到线索挖掘产品用户的公司名称
     * @return
     */
    public List<ComName> getClueminCompany();

    /**
     * 用于更新爬虫抓取数据源
     */
    public void updateData(ZqDataSource zqDataSource);

    /**
     * 得到clueminingPCP公司名称
     * @return
     */
    public List<ComName> getPcpName();
}
