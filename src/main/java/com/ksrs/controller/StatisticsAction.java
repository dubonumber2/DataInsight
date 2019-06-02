package com.ksrs.controller;


import com.ksrs.entity.Statistics;
import com.ksrs.service.StatisticsServie;

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
@Controller
@RequestMapping("/statis")
public class StatisticsAction {
    @Autowired
    StatisticsServie statisticsServie;

    public void setStatisticsServie(StatisticsServie statisticsServie) {
        this.statisticsServie = statisticsServie;
    }
    @RequestMapping("/getAll.action")

    public @ResponseBody
    LayUiUtils getAll(HttpServletResponse response, int page, int limit) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay = new LayUiUtils();

        List<Statistics> list = statisticsServie.getAll(page, limit);
        lay.setCode(0);
        lay.setMsg(",");
        lay.setCount(statisticsServie.getTotal());



        lay.setData(list);
        return  lay;
    }
}