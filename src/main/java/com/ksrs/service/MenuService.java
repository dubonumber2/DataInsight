package com.ksrs.service;

import com.ksrs.entity.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */
public interface MenuService {
    public List<Menu> getAllMenu();

    public List<Menu> getMenuByroleid(int role_id);
}
