package com.ksrs.controller;

import com.ksrs.entity.ClueminingApiExpand;
import com.ksrs.entity.Cluemining_api;
import com.ksrs.entity.User_operation;
import com.ksrs.service.Cluemining_apiService;
import com.ksrs.service.User_operationService;
import com.ksrs.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/useroperation")
public class User_operationAction {
    @Autowired
    private User_operationService user_operationService;
    @Autowired
    private Cluemining_apiService cluemining_apiService;

    public void setCluemining_apiService(Cluemining_apiService cluemining_apiService) {
        this.cluemining_apiService = cluemining_apiService;
    }

    public void setUser_operationService(User_operationService user_operationService) {
        this.user_operationService = user_operationService;
    }

    @RequestMapping("/getByName1.action")
    public @ResponseBody LayUiUtils getByName1(HttpServletResponse response, String operation_name,String end_time, String operation_time, String user_name,String user_company,String realname,String user_type,String dowload,int page, int limit){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay = new LayUiUtils();
        List<User_operation> list=user_operationService.getByOpName(operation_time,end_time,operation_name,user_name,user_company,realname,user_type,page,limit);
        if("dowload".equals(dowload)){
            ClueminingDowload.dowload(response,list);
        }
        lay.setData(list);
        lay.setCount(user_operationService.getTotal(operation_time, end_time,operation_name, user_name,user_company,realname,user_type));
        lay.setCode(0);
        lay.setMsg(",");
        return lay;

    }
    @RequestMapping("/dowloadByName1.action")
    public @ResponseBody LayUiUtils dowload1(HttpServletResponse response, String operation_name,String end_time, String operation_time, String user_name,String user_company,String realname,String user_type,String dowload,int page){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int total=user_operationService.getTotal(operation_time, end_time,operation_name, user_name,user_company,realname,user_type);
        List<User_operation> list=user_operationService.getByOpName(operation_time,end_time,operation_name,user_name,user_company,realname,user_type,page,total);
        ClueminingDowload.dowload(response,list);
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg("下载成功");
        lay.setCode(200);
        return  lay;
    }
    @RequestMapping("/getByName2.action")
    public @ResponseBody LayUiUtils getByName2(HttpServletResponse response, String operation_name,String end_time, String operation_time, String user_name,String user_company,String realname,String user_type,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay = new LayUiUtils();
        List<User_operation> list=user_operationService.getByDowload(operation_time,end_time,operation_name,user_name,user_company,realname,user_type);
        if("dowload".equals(dowload)){
            ClueminingDowload1.dowload(response,list);
        }
        lay.setData(list);
        lay.setCount(1000);
        lay.setCode(0);
        lay.setMsg(",");
        return lay;

    }
    @RequestMapping("/getSum.action")
    public @ResponseBody LayUiUtils getSum(String user_company,HttpServletResponse response,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay = new LayUiUtils();
        List<User_operation> list=user_operationService.getSum(user_company);
        if("dowload".equals(dowload)){
            ClueminingDowload2.dowload(response,list);
        }
        lay.setData(list);
        lay.setCount(1000);
        lay.setCode(0);
        lay.setMsg(",");
        return lay;
    }
    @RequestMapping("/insertUser.action")
    public void insertUser(User_operation user_operation,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            user_operationService.insertUser(user_operation);
            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("faile");
        } finally {
            out.close();
        }
    }

    @RequestMapping("/getUser.action")
    public @ResponseBody LayUiUtils getUser(HttpServletResponse response,int page,int limit){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<User_operation> list=user_operationService.getUser(limit,page);
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(user_operationService.getUserTotal());
        lay.setData(list);
        return lay;
    }
    @RequestMapping("/getApi.action")
    public @ResponseBody LayUiUtils getData(HttpServletResponse response,String starDate,String endDate,String operation_explain,String operation_type,String dowload,int page,int limit){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Cluemining_api> list=cluemining_apiService.getData(starDate,endDate,operation_explain,operation_type,page,limit);
        if("dowload".equals(dowload)){
            ApiDowload.dowload(response,list);
        }
        //System.out.println(list.get(1).getIp_service());
        LayUiUtils lay=new LayUiUtils();
        lay.setData(list);
        lay.setCount(cluemining_apiService.getTotal(starDate, endDate, operation_explain,operation_type));
        lay.setCode(0);
        lay.setMsg(",");
        return lay;
    }

    @RequestMapping("/getExpand.action")
    public @ResponseBody LayUiUtils getExpand(HttpServletResponse response,int page,int limit,String ip){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay = new LayUiUtils();
        List<ClueminingApiExpand> list = cluemining_apiService.getPage(page,limit,ip);
        lay.setCount(cluemining_apiService.getExpandTotal(ip));
        lay.setMsg(",");
        lay.setCode(0);
        lay.setData(list);
        return lay;
    }

}
