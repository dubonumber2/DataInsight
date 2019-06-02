package com.ksrs.service;

import com.ksrs.entity.User_operation;

import java.util.List;

public interface ClueminingPcpService {
    /**
     * 根据各种条件查询用户的行为
     * @return
     */
    public List<User_operation> getByOpName(String operation_time, String end_time, String operation_name, String user_name, String user_company, String realname, String user_type, int page, int pageSize);
    /**
     * 下载操作  显示不同数据
     * @return
     */
    public List<User_operation> getByDowload(String operation_time,String end_time,String operation_name,String user_name,String user_company,String realname,String user_type);

    /**
     * 得到分页的总条数
     * @param operation_time
     * @param operation_name
     * @param user_name
     * @return
     */
    public int  getTotal(String operation_time,String end_time,String operation_name,String user_name,String user_company,String realname,String user_type);
    /**
     * 通过公司名称得到汇总信息
     * @param user_company
     * @return
     */
    public List<User_operation> getSum(String user_company);
    /**
     * 录入线索挖掘用户信息的接口
     * @param user_operation
     */
    public void insertUser(User_operation user_operation);
    /**
     * 查询现有线索挖掘用户
     * @return
     */
    public List<User_operation> getUser(int pageSize,int page);

    /**
     * 得到线索挖掘用户的总条数
     * @return
     */
    public int getUserTotal();
}
