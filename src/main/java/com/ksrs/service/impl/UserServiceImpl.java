package com.ksrs.service.impl;

import com.ksrs.dao.UserDao;
import com.ksrs.entity.User;
import com.ksrs.service.UserService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
@Service
@DataSource("dataSource2") // 使用第二个数据源
public class UserServiceImpl implements UserService {

    @Autowired
   private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",username);map.put("password",password);
        return userDao.login(map);
    }

    @Override
    public int getTotal() {
        return userDao.getTotal();
    }

    @Override
    public List<User> getPage(int start, int pagesize) {
        Map<String,Integer> map=new HashMap<String, Integer>();
        int a=(start-1)*pagesize;
        map.put("start",a);map.put("pagesize",pagesize);
        return userDao.getPage(map);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
