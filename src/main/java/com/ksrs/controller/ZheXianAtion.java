package com.ksrs.controller;

import com.ksrs.entity.LinGan;
import com.ksrs.entity.ZheXian;
import com.ksrs.service.ZheXianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Controller
@RequestMapping("/zhexian")
public class ZheXianAtion {
    @Autowired
    private ZheXianService zheXianService;

    public void setZheXianService(ZheXianService zheXianService) {
        this.zheXianService = zheXianService;
    }

    @RequestMapping("/getdata.action")

    public @ResponseBody
    ZheXian getdata(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        return  zheXianService.getdata();
    }

    @RequestMapping("/getcomdate.action")
    public @ResponseBody
    ZheXian getComDate(HttpServletResponse response, String name){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        ZheXian zheXian=null;
        if(name==null|| "".equals(name)){
            zheXian=zheXianService.getdata();
        }else{
            zheXian=zheXianService.getComDate(name);
        }
        return zheXian;
    }

    @RequestMapping("/getsumdata.action")
    public @ResponseBody List<LinGan> getSumData(){
        Date date = new Date();
        Date yesterday = new Date(date.getTime());
        Date str=new Date(date.getTime()-86400000L*7);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String endDate = sdf.format(yesterday);
        String starDate=sdf.format(str);
        List<LinGan> list=zheXianService.getsumdata(starDate,endDate);
        return  list;
    }

}
