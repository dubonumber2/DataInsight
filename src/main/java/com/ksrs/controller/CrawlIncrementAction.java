package com.ksrs.controller;


import com.ksrs.entity.CrawlIncrement;

import com.ksrs.service.CrawlIncrementService;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import java.util.List;


/**
 * Created by Administrator on 2017/10/12 0012.
 */
@RequestMapping("/incrmt")
@Controller
public class CrawlIncrementAction {
    @Autowired
    CrawlIncrementService crawlIncrementService;

    public void setCrawlIncrementService(CrawlIncrementService crawlIncrementService) {
        this.crawlIncrementService = crawlIncrementService;
    }
    @RequestMapping("/getAll.action")

    public @ResponseBody
    LayUiUtils getAll(HttpServletResponse response, int limit, int page){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int total=crawlIncrementService.getTotal();
        LayUiUtils<CrawlIncrement> lay=new LayUiUtils<CrawlIncrement>();
        lay.setCount(total);
        lay.setCode(0);
        lay.setMsg(",");
        List<CrawlIncrement> list = crawlIncrementService.getAll(page,limit);


        lay.setData(list);
        return lay;
    }
    @RequestMapping("/getByDate.action")
    public @ResponseBody
    LayUiUtils getByDate(HttpServletResponse response, String end, String start, int page, int limit){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.print(start+" "+end);
        System.out.print(limit+"  "+page);
        int total=crawlIncrementService.getTotalByDate(start,end);
        System.out.println(total);
        LayUiUtils<CrawlIncrement> lay=new LayUiUtils<CrawlIncrement>();
        List<CrawlIncrement> list=crawlIncrementService.getByDate(start,end,page,limit);
        lay.setMsg(",");
        lay.setCount(total);
        lay.setCode(0);
        lay.setData(list);
        return lay;
    }
    @RequestMapping("/getDetail.action")
    public @ResponseBody LayUiUtils getDetail(HttpServletResponse response,String name,String start,String end,int limit,int page){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils<CrawlIncrement> lay=new LayUiUtils<CrawlIncrement>();
        lay.setMsg(",");
        lay.setCode(0);
        System.out.println(start+"  "+start.length());
        System.out.println(end+" "+end.length());
        System.out.println(name+" "+name.length());
        if(end.length()==0&&name.length()!=0&&name!=null){
            System.out.print("进入只按名字查询");
            List<CrawlIncrement> list=crawlIncrementService.getDetailByName(name,page,limit);
            System.out.println(name);
            lay.setCount(crawlIncrementService.getTotalDetailByName(name));
            lay.setData(list);
        }else if((start.length()!=0&&end.length()!=0)&&(name==null||name.length()==0)){
            System.out.print("进入只按时间段查询");
            List<CrawlIncrement> list=crawlIncrementService.getByDate(start,end,page,limit);
            int total=crawlIncrementService.getTotalByDate(start,end);
            lay.setCount(total);
            lay.setData(list);
        }else if(end.length()!=0&&start.length()!=0&&(name!=null)&&!"".equals(name)){
            System.out.print("进入按时间和名字查询");
            List<CrawlIncrement> list=crawlIncrementService.getByDateName(name,start,end,page,limit);
            int total=crawlIncrementService.getTotalByDateName(name,start,end);
            lay.setCount(total);
            lay.setData(list);
        }else{
            int total=crawlIncrementService.getTotal();
            List<CrawlIncrement> list = crawlIncrementService.getAll(page,limit);
            lay.setCount(total);
            lay.setData(list);
        }

        return lay;
    }
}
