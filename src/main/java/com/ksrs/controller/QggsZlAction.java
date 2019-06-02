package com.ksrs.controller;

import com.ksrs.entity.Hzb;
import com.ksrs.entity.QggsZl;
import com.ksrs.entity.Statistics_hz;
import com.ksrs.service.QggsZlService;
import com.ksrs.service.Statistics_hzService;
import com.ksrs.utils.DowloadUtils3;
import com.ksrs.utils.DowloadUtils4;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Controller
@RequestMapping("/gszl")
public class QggsZlAction {
    @Autowired
    QggsZlService qggsZlService;
    @Autowired
    Statistics_hzService statistics_hzService;

    public void setStatistics_hzService(Statistics_hzService statistics_hzService) {
        this.statistics_hzService = statistics_hzService;
    }

    public void setQggsZlService(QggsZlService qggsZlService) {
        this.qggsZlService = qggsZlService;
    }
    @RequestMapping("/getAll.action")
    public
    @ResponseBody
    LayUiUtils getDataByDate(HttpServletResponse response, String endDate,String dowload) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<QggsZl> list=null;
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(1000);
        if ("".equals(endDate) || null == endDate || "undefined".equals(endDate)) {
            Date date = new Date();
            Date yesterday = new Date(date.getTime() - 86400000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            endDate = sdf.format(yesterday);
            list = qggsZlService.getDataByDate(endDate);
            if("dowload".equals(dowload)) {
                DowloadUtils3.dowload(response, list);
            }
        }else{
            list=qggsZlService.getDataByDate(endDate);
            if("dowload".equals(dowload)){

                DowloadUtils3.dowload(response,list);
            }

        }
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/getJyz.action")
    public @ResponseBody LayUiUtils getJyzData(HttpServletResponse response, String endDate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<QggsZl> list=null;
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(1000);
        if ("".equals(endDate) || null == endDate || "undefined".equals(endDate)) {
            Date date = new Date();
            Date yesterday = new Date(date.getTime() - 86400000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            endDate = sdf.format(yesterday);
            list = qggsZlService.getJyzData(endDate);
            if("dowload".equals(dowload)) {
                DowloadUtils3.dowload(response, list);
            }
        }else{
            list=qggsZlService.getJyzData(endDate);
            if("dowload".equals(dowload)){
                DowloadUtils3.dowload(response,list);
            }

        }
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/getFzc.action")
    public @ResponseBody LayUiUtils getFzc(HttpServletResponse response, String endDate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<QggsZl> list=null;
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(1000);
        if ("".equals(endDate) || null == endDate || "undefined".equals(endDate)) {
            Date date = new Date();
            Date yesterday = new Date(date.getTime() - 86400000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            endDate = sdf.format(yesterday);
            list = qggsZlService.getFzcData(endDate);
            if("dowload".equals(dowload)) {
                DowloadUtils3.dowload(response, list);

            }
        }else{
            list=qggsZlService.getFzcData(endDate);
            if("dowload".equals(dowload)){
                DowloadUtils3.dowload(response,list);
            }

        }
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/getQt.action")
    public @ResponseBody LayUiUtils getQt(HttpServletResponse response, String endDate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<QggsZl> list=null;
        LayUiUtils lay=new LayUiUtils();
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(1000);
        if ("".equals(endDate) || null == endDate || "undefined".equals(endDate)) {
            Date date = new Date();
            Date yesterday = new Date(date.getTime() - 86400000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            endDate = sdf.format(yesterday);
            list = qggsZlService.getQtData(endDate);
            if("dowload".equals(dowload)) {
                DowloadUtils3.dowload(response, list);
            }
        }else{
            list=qggsZlService.getQtData(endDate);
            if("dowload".equals(dowload)){
                DowloadUtils3.dowload(response,list);
            }

        }
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/getHz.action")
    public @ResponseBody LayUiUtils getHz(HttpServletResponse response, String endDate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Hzb> list=new ArrayList<>();
        Statistics_hz statistics_hz=null;
        Statistics_hz statistics_hz1=null;
        if ("".equals(endDate) || null == endDate || "undefined".equals(endDate)) {
            Date date = new Date();
            Date yesterday = new Date(date.getTime() - 86400000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            endDate = sdf.format(yesterday);
            statistics_hz = statistics_hzService.getData(endDate);
            statistics_hz1 = statistics_hzService.getQyData(endDate);
        }else{
            statistics_hz = statistics_hzService.getData(endDate);
            statistics_hz1 = statistics_hzService.getQyData(endDate);
        }

        Hzb a1=new Hzb();
        a1.setZhiBiao("总量");
        try {
            a1.setZlxs(String.valueOf(statistics_hz.getTotal()));
            a1.setQyxs(String.valueOf(statistics_hz1.getTotal()));
        }catch(NullPointerException e ){
            e.printStackTrace();

        }
        list.add(a1);
        Hzb a2=new Hzb();
        a2.setZhiBiao("总量占比");
        a2.setZlxs(String.valueOf(statistics_hz.getTotal_cov()));
        a2.setQyxs(String.valueOf(statistics_hz1.getTotal_cov()));
        list.add(a2);
        Hzb a3=new Hzb();
        a3.setZhiBiao("完整数据(交集)");
        a3.setZlxs(String.valueOf(statistics_hz.getComplete_data()));
        a3.setQyxs(String.valueOf(statistics_hz1.getComplete_data()));
        list.add(a3);
        Hzb a4=new Hzb();
        a4.setZhiBiao("完整数据(交集)占比");
        a4.setZlxs(String.valueOf(statistics_hz.getComplete_data_cov()));
        a4.setQyxs(String.valueOf(statistics_hz1.getComplete_data_cov()));
        list.add(a4);
        Hzb a5=new Hzb();
        a5.setZhiBiao("正常经营总量");
        a5.setZlxs(String.valueOf(statistics_hz.getNormal_total()));
        a5.setQyxs(String.valueOf(statistics_hz1.getNormal_total()));
        list.add(a5);
        Hzb a6=new Hzb();
        a6.setZhiBiao("正常经营总量占比");
        a6.setZlxs(String.valueOf(statistics_hz.getNormal_total_cov()));
        a6.setQyxs(String.valueOf(statistics_hz1.getNormal_total_cov()));
        list.add(a6);
        Hzb a7=new Hzb();
        a7.setZhiBiao("正常经营&完整数据（交集）总量");
        a7.setZlxs(String.valueOf(statistics_hz.getNor_com_data()));
        a7.setQyxs(String.valueOf(statistics_hz1.getNor_com_data()));
        list.add(a7);
        Hzb a8=new Hzb();
        a8.setZhiBiao("正常经营&完整数据（交集）总量占比");
        a8.setZlxs(String.valueOf(statistics_hz.getNor_com_data_cov()));
        a8.setQyxs(String.valueOf(statistics_hz1.getNor_com_data_cov()));
        list.add(a8);
        Hzb a9=new Hzb();
        a9.setZhiBiao("活跃总量");
        a9.setZlxs(String.valueOf(statistics_hz.getActive_data()));
        a9.setQyxs(String.valueOf(statistics_hz1.getActive_data()));
        list.add(a9);
        Hzb b1=new Hzb();
        b1.setZhiBiao("活跃总量占比");
        b1.setZlxs(String.valueOf(statistics_hz.getActive_data_cov()));
        b1.setQyxs(String.valueOf(statistics_hz1.getActive_data_cov()));
        list.add(b1);
        Hzb b2=new Hzb();
        b2.setZhiBiao("销售相关总量");
        b2.setZlxs(String.valueOf(statistics_hz.getSale_data()));
        b2.setQyxs(String.valueOf(statistics_hz1.getSale_data()));
        list.add(b2);
        Hzb b3=new Hzb();
        b3.setZhiBiao("销售相关占比");
        b3.setZlxs(String.valueOf(statistics_hz.getSale_data_cov()));
        b3.setQyxs(String.valueOf(statistics_hz1.getSale_data_cov()));
        list.add(b3);
        if("".equals(endDate) || null == endDate || "undefined".equals(endDate)){
            if("dowload".equals(dowload)){
                DowloadUtils4.dowload(response,list);
            }
        }else{
            if("dowload".equals(dowload)){
                DowloadUtils4.dowload(response,list);
            }
        }


        LayUiUtils lay=new LayUiUtils();
        lay.setData(list);
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(1000);
        return lay;


    }

}