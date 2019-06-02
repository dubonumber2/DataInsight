package com.ksrs.dao;

import com.ksrs.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface RoleDao {
    public List<Role> getAll();
    public Role getByName(String rolename);
    public void fenpei(Map<String,Integer> map);
    public void insertPerm(Map<String,Integer> map);
    public void deletePerm(int role_id);
    public int test(int role_id);

    /**
     * 根据用户id修改权限
     */
    public void updateFenpei(@Param("user_id")int user_id,@Param("role_id")int role_id);

    /**
     * 根据用户id删除用户—角色表相关数据
     */
    public void deleteRole_user(@Param("user_id")int user_id);
}
