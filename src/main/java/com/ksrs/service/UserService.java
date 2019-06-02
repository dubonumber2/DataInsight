package com.ksrs.service;

import com.ksrs.entity.User;

import java.util.List;


/**
 * Created by Administrator on 2017/10/20 0020.
 */

public interface UserService {
    public User login(String username, String password);
    public int getTotal();
    public List<User> getPage(int start,int pagesize);
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
    public void deleteUser(Integer id);
}
