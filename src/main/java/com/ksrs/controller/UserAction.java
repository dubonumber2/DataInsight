package com.ksrs.controller;

import com.ksrs.VO.ResultVO;
import com.ksrs.entity.Role;
import com.ksrs.entity.User;
import com.ksrs.enums.ResultEnum;
import com.ksrs.exception.MyException;
import com.ksrs.service.RoleService;
import com.ksrs.service.UserService;
import com.ksrs.utils.LayUiUtils;
import com.ksrs.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login.action")
    public void login(HttpServletRequest request, HttpServletResponse response, String username, String password){
            User user=userService.login(username, password);
            String msg="";
            PrintWriter out=null;
        try {
            out=response.getWriter();
            if(user!=null){
                request.getSession().setAttribute("user",user);
                msg="success";

            }else{
                msg="no";
            }
        } catch (IOException e) {
            e.printStackTrace();
            msg="error";
        }finally {
            out.print(msg);
            System.out.println(msg);
            out.flush();
            out.close();
        }


    }
    @RequestMapping("/getMsg.action")
    public void getMsg(HttpSession session,HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        User user = (User) session.getAttribute("user");
        String realName="";

        if (null!=user) {
             realName = user.getRealName();

        }else{
            realName="请登录";
        }
        PrintWriter out=null;
        try {
            out=response.getWriter();
            out.print(realName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/getpage.action")
    public @ResponseBody
    LayUiUtils getPage(HttpServletResponse response,int page,int limit){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<User> list=userService.getPage(page,limit);
        LayUiUtils lay=new LayUiUtils();
        int total=userService.getTotal();
        lay.setCount(total);
        lay.setMsg(",");
        lay.setCode(0);
        lay.setData(list);
        return lay;
    }
    @RequestMapping("/insertUser.action")
    public void insertUser(HttpServletResponse response,User user,String type,String rolename,int user_id){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out=null;
        String msg="";
        try {
             out = response.getWriter();
        if("insert".equals(type)) {
            System.out.println("jinlaile?");
                userService.insertUser(user);
                out.print("success");

        }else{
            userService.updateUser(user);
            Role role=roleService.getByName(rolename);
            int role_id=role.getId();
            roleService.updateFenpei(user_id,role_id);
            out.print("success");
        }
        } catch (IOException e) {
            e.printStackTrace();
            out.print("no");
        }finally {
            out.close();
        }
    }
    @RequestMapping("/deleteUser.action")
    public void deleteUser(Integer id,HttpServletResponse response){
        PrintWriter out=null;
        try {
            out = response.getWriter();
            userService.deleteUser(id);
            roleService.deleteRole_user(id);
            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("no");
        }finally {
            out.close();
        }

    }
    @RequestMapping("/logout.action")
    @ResponseBody
    public ResultVO logout(HttpServletResponse response, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        try {
            response.sendRedirect("/login.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(user == null || user.toString().equals("")){
            throw new MyException(ResultEnum.NOT_LOGIN);
        }
        request.getSession().removeAttribute("user");

        return ResultUtil.success();
    }

    @RequestMapping("/shiro.action")
    public void shiro(HttpServletResponse response,HttpServletRequest request){
        if(request.getSession().getAttribute("user") == null){
            try {
                response.sendRedirect("/login.html");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
