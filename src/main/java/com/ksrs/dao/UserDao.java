package com.ksrs.dao;

import com.ksrs.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public interface UserDao {
    /**
     * 登录
     * @param map
     * @return
     */
    public User login(Map<String,String> map);
    public List<User> getPage(Map<String,Integer> map);
    public int getTotal();

    /**
     * 添加用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 编辑用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(@Param("id") Integer id);
}
