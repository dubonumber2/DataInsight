package com.ksrs.dao;

import com.ksrs.entity.User_operation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface User_operationDao {
    /**
     * 根据各种条件查询用户的行为
     * @return
     */
    public List<User_operation> getByOpName(@Param("operation_time")String operation_time,@Param("end_time")String end_time,@Param("operation_name")String operation_name,@Param("user_name")String user_name,@Param("user_company")String user_company,@Param("realname")String realname,@Param("user_type")String user_type,@Param("page")int page,@Param("pageSize")int pageSize);

    /**
     * 如果是查看下载操作  显示不同的数据
     * @param operation_time
     * @param operation_name
     * @param user_name
     * @return
     */
    public List<User_operation> getByDowload(@Param("operation_time")String operation_time,@Param("end_time")String end_time,@Param("operation_name")String operation_name,@Param("user_name")String user_name,@Param("user_company")String user_company,@Param("realname")String realname,@Param("user_type")String user_type);

    /**
     * 得到分页的总条数
     * @param operation_time
     * @param operation_name
     * @param user_name
     * @return
     */
    public int getTotal(@Param("operation_time")String operation_time,@Param("end_time")String end_time,@Param("operation_name")String operation_name,@Param("user_name")String user_name,@Param("user_company")String user_company,@Param("realname")String realname,@Param("user_type")String user_type);

    /**
     * 通过公司名称得到汇总信息
     * @param user_company
     * @return
     */
    public List<User_operation> getSum(@Param("user_company")String user_company);

    /**
     * 录入线索挖掘用户信息的接口
     * @param user_operation
     */
    public void insertUser(User_operation user_operation);

    /**
     * 查询现有线索挖掘用户
     * @return
     */
    public List<User_operation> getUser(Map<String,Integer> map);

    /**
     * 得到线索挖掘用户的总条数
     * @return
     */
    public int getUserTotal();

}
