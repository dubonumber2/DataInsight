package com.ksrs.controller;

import com.ksrs.entity.LongCai;
import com.ksrs.service.LongCaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/longcai")
public class LongCaiController {
    @Autowired
    private LongCaiService longCaiService;

    @RequestMapping("/getData.action")
    public @ResponseBody
    List<LongCai> getData(HttpServletResponse httpServletResponse,String starDate,String endDate){
        return longCaiService.getData(starDate, endDate);
    }
    @RequestMapping("/getOne.action")
    public @ResponseBody LongCai getOne(HttpServletResponse httpServletResponse){
        //得到最新的一条记录
        return longCaiService.getOne();
    }
    @RequestMapping("/getCzData.action")
    public @ResponseBody
    List<LongCai> getCzData(HttpServletResponse httpServletResponse,String starDate,String endDate){
        return longCaiService.getCzData(starDate, endDate);
    }
}
