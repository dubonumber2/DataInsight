package com.ksrs.service;

import com.ksrs.entity.Role;

import java.util.List;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface RoleService {
    public List<Role> getAll();
    public Role getByName(String name);
    public void fenpei(int user_id,int role_id);
    public void insertPerm(int role_id,int menu_id);
    public void deletePerm(int role_id);
    public int test(int role_id);
    /**
     * 根据用户id修改权限
     */
    public void updateFenpei(int user_id,int role_id);

    /**
     * 根据用户id删除用户—角色表相关数据
     */
    public void deleteRole_user(int user_id);
}
