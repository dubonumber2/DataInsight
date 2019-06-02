package com.ksrs.controller;

import com.ksrs.entity.Role;
import com.ksrs.service.RoleService;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
    @Autowired
    RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @RequestMapping("/getAll.action")
    public @ResponseBody
    LayUiUtils getAll(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Role> list=roleService.getAll();
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setCount(0);
        lay.setMsg(",");
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/fenpei.action")
    public void fenpei(HttpServletResponse response,String rolename,int user_id){
        Role role=null;
        int role_id=0;
        String msg="";
        String x="undefined";
        if(rolename!=null&&rolename!=""&&!x.equals(rolename)){
            role = roleService.getByName(rolename);
            role_id = role.getId();
        }
        PrintWriter out=null;
        try {
            out=response.getWriter();
            if(user_id!=0&&role_id!=0){
                roleService.fenpei(user_id,role_id);
                msg="success";
            }else{
                msg="no";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.print(msg);
            out.flush();
            out.close();
        }
    }
    @RequestMapping("/getlist.action")
    public @ResponseBody List<Role> getList(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Role> list=roleService.getAll();
        return list;
    }
    @RequestMapping("/insertPerm.action")
    public void insertPerm(String arr,int role_id,HttpServletResponse response){
        PrintWriter out=null;


        String[] arrs=arr.substring(1, arr.length()-1).split(",");
        int test=roleService.test(role_id);
        if(test!=0){
            roleService.deletePerm(role_id);
        }
        for(int i=0;i<arrs.length;i++){
            int menu_id=Integer.parseInt(arrs[i]);
            roleService.insertPerm(role_id,menu_id);
        }
        try {
            out=response.getWriter();
            out.print("success");
        } catch (IOException e) {
            out.print("error");
            e.printStackTrace();
        }finally{
            out.flush();
            out.close();
        }
    }

}
