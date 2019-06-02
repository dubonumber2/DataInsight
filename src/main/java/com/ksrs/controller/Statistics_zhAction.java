package com.ksrs.controller;

import com.ksrs.entity.Statistics_zh;
import com.ksrs.service.Statistics_zhService;
import com.ksrs.utils.DowloadMongo;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018/1/11 0011.
 */
@Controller
@RequestMapping("/mongo")
public class Statistics_zhAction {
    @Autowired
    private Statistics_zhService statistics_zhService;

    public void setStatistics_zhService(Statistics_zhService statistics_zhService) {
        this.statistics_zhService = statistics_zhService;
    }
    @RequestMapping("/getDate.action")
    public @ResponseBody LayUiUtils getData(String date, HttpServletResponse response,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        List<Statistics_zh> list=statistics_zhService.getByDate(date);
        if("dowload".equals(dowload)){
            DowloadMongo.dowload(response,list);
        }
        lay.setCode(0);
        lay.setCount(list.size());
        lay.setMsg(",");
        lay.setData(list);
        return  lay;
    }
}
