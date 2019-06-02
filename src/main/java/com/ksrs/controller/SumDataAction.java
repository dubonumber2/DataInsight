package com.ksrs.controller;

import com.ksrs.entity.SumData;
import com.ksrs.service.SumDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@Controller
@RequestMapping("/sumdata")
public class SumDataAction {
    @Autowired
    private SumDataService sumDataService;

    public void setSumDataService(SumDataService sumDataService) {
        this.sumDataService = sumDataService;
    }
    @RequestMapping("/getdata.action")
    public @ResponseBody
    SumData getdata(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        SumData sumData=sumDataService.getdata();
        return sumData;
    }
}
