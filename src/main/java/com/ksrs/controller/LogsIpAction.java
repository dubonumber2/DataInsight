package com.ksrs.controller;

import com.ksrs.entity.LogsIp;
import com.ksrs.service.LogsIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
@Controller
@RequestMapping("/logsip")
public class LogsIpAction {
    @Autowired
    LogsIpService logsIpService;

    public void setLogsIpService(LogsIpService logsIpService) {
        this.logsIpService = logsIpService;
    }
    @RequestMapping("/getIpSendHttp.action")
    public @ResponseBody
    List<LogsIp> getIpSendHttp(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LogsIp> list=logsIpService.getIpSendHttp();
        return list;
    }
    @RequestMapping("/getSaotu.action")
    public @ResponseBody List<LogsIp> getSaotu(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LogsIp> list=logsIpService.getSaotu();
        return list;
    }
    @RequestMapping("/getLouDou.action")
    public @ResponseBody List<LogsIp> getLouDou(){
        List<LogsIp> list=logsIpService.getLouDou();
        return list;
    }
    @RequestMapping("/getLouDouByDate.action")
    public @ResponseBody List<LogsIp> getLouDouByDate(HttpServletResponse response,String endDate){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LogsIp> list=logsIpService.getLouDouByDate(endDate);
        return  list;
    }
}
