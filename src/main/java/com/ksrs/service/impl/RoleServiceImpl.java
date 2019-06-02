package com.ksrs.service.impl;

import com.ksrs.dao.RoleDao;
import com.ksrs.entity.Role;
import com.ksrs.service.RoleService;
import com.ksrs.utils.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@Service
@DataSource("dataSource2") // 使用第二个数据源
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @Override
    public void fenpei(int user_id, int role_id) {
        Map<String,Integer> map=new HashMap<String,Integer>(10);
        map.put("user_id",user_id);map.put("role_id",role_id);
        roleDao.fenpei(map);
    }

    @Override
    public void insertPerm(int role_id, int menu_id) {
        Map<String,Integer> map=new HashMap<String,Integer>(10);
        map.put("role_id",role_id);map.put("menu_id",menu_id);
        roleDao.insertPerm(map);
    }

    @Override
    public void deletePerm(int role_id) {
        roleDao.deletePerm(role_id);
    }

    @Override
    public int test(int role_id) {
        return roleDao.test(role_id);
    }

    @Override
    public void updateFenpei(int user_id, int role_id) {
        roleDao.updateFenpei(user_id, role_id);
    }

    @Override
    public void deleteRole_user(int user_id) {
        roleDao.deleteRole_user(user_id);
    }
}
