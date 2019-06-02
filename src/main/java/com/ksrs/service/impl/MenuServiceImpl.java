package com.ksrs.service.impl;

import com.ksrs.dao.MenuDao;
import com.ksrs.entity.Menu;
import com.ksrs.service.MenuService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
@Service
@DataSource("dataSource2") /** 使用第二个数据源*/
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Override
    public List<Menu> getMenuByroleid(int role_id) {
        return menuDao.getMenuByroleid(role_id);
    }

}
