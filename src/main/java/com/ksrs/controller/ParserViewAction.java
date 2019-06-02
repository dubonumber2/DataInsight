package com.ksrs.controller;

import com.ksrs.entity.ParserView;
import com.ksrs.service.ParserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/11/17 0017.
 */
@Controller
@RequestMapping("/parser")
public class ParserViewAction {
    @Autowired
    ParserViewService parserViewService;

    public void setParserViewService(ParserViewService parserViewService) {
        this.parserViewService = parserViewService;
    }
    @RequestMapping("/getData.action")
    public @ResponseBody
    List<ParserView> getData(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ParserView> list=parserViewService.getData();
        return  list;
    }
    @RequestMapping("/getDataByDate.action")
    public @ResponseBody List<ParserView> getDataByDate(HttpServletResponse response,String startDate,String endDate){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(startDate+" "+endDate);
        List<ParserView> list=parserViewService.getDataByDate(startDate, endDate);
        return list;
    }

    @RequestMapping("/getIpHttpDate.action")
    public @ResponseBody List<ParserView> getIpHttpDate(HttpServletResponse response,String startDate,String endDate){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ParserView> list=parserViewService.getIpHttpDate(startDate, endDate);
        return list;

    }
    @RequestMapping("/getIpHttp.action")
    public @ResponseBody List<ParserView> getIpHttp(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ParserView> list=parserViewService.getIpHttp();
        return  list;
    }
    @RequestMapping("/getHttpByDate.action")
    public @ResponseBody List<ParserView> getHttpByDate(String startDate,String endDate,String type){
       String yz="List";
        String yz1="detail";
        List<ParserView> list=null;
        if(yz.equals(type)){
            list=parserViewService.getListHttpByDate(startDate, endDate);
        }else if(yz1.equals(type)){
            list=parserViewService.getDetailHttpByDate(startDate, endDate);
        }
        return list;
    }
    @RequestMapping("/getHttp.action")
    public @ResponseBody List<ParserView> getHttp(String type){
        String yz="List";
        String yz1="detail";
        List<ParserView> list=null;
        if(yz.equals(type)){
            list=parserViewService.getListHttp();
        }else if(yz1.equals(type)){
            list=parserViewService.getDetailHttp();
        }
        return list;
    }

}
