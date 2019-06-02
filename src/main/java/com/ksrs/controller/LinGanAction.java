package com.ksrs.controller;

import com.ksrs.entity.LinGan;
import com.ksrs.service.LinGanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@RequestMapping("/lingan")
@Controller
public class LinGanAction {
    @Autowired
    LinGanService linGanService;

    public void setLinGanService(LinGanService linGanService) {
        this.linGanService = linGanService;
    }
    @RequestMapping("/getData.action")
    public @ResponseBody List<LinGan> getByDate(HttpServletResponse response, String starDate, String endDate,String comname){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LinGan> list=new ArrayList<LinGan>();
        boolean a=(starDate==""||starDate==null||"undefined".equals(starDate))&&(endDate==""||endDate==null||"undefined".equals(endDate))&&
                (comname==""||comname==null||"undefined".equals(comname));
        boolean b=(starDate!=null&&starDate!=""&&!"undefined".equals(starDate))&&(endDate!=null&&endDate!=""&&!"undefined".equals(endDate))&&
                (comname!=null&&comname!=""&&!"undefined".equals(comname));
        boolean c=(starDate!=null&&starDate!=""&&!"undefined".equals(starDate))&&(endDate!=null&&endDate!=""&&!"undefined".equals(endDate))&&
                (comname==null||comname==""||"undefined".equals(comname));
        if(a){
            list=linGanService.getData();
        }else if(b){
            list=linGanService.getByDateCom(starDate,endDate,comname);
        }else if(c){
            list=linGanService.getByDate(starDate, endDate);
        }
        return list;
    }
    @RequestMapping("/getOpenData.action")
    public @ResponseBody List<LinGan> getOpenData(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        return linGanService.getOpenData();

    }
    @RequestMapping("/getReqData.action")
    public @ResponseBody List<LinGan> getReqData(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        return  linGanService.getReqData();
    }
    @RequestMapping("/getLogsData.action")
    public @ResponseBody List<LinGan> getLogsData(HttpServletResponse response,String type){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String yp="list";
        List<LinGan> list=null;
        if(yp.equals(type)){
            list=linGanService.getListData();
        }else{
            list=linGanService.getDetailData();
        }
        return  list;
    }
    @RequestMapping("/getLogsDataByDate.action")
    public @ResponseBody List<LinGan> getLogsByDate(HttpServletResponse response,String startDate,String endDate,String type){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String typeThis="list";
        List<LinGan> list=null;
        if(typeThis.equals(type)){
            list=linGanService.getListDataByDate(startDate, endDate);
        }else{
            list=linGanService.getDetailDataByDate(startDate, endDate);
        }
        return list;

    }
    @RequestMapping("/getOpenDataByDate.action")
    public @ResponseBody List<LinGan> getOpenByDate(HttpServletResponse response,String startDate,String endDate,String type){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String typeThis="req";
        List<LinGan> list=null;
        if(typeThis.equals(type)){
            list=linGanService.getReqDataByDate(startDate, endDate);
        }else{
            list=linGanService.getOpenDataByDate(startDate, endDate);
        }
        return list;

    }
    @RequestMapping("/getSumDl.action")
    public @ResponseBody List<LinGan> getSumDl(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LinGan> list=linGanService.getSumDetailList();
        return list;
    }
    @RequestMapping("/getSumDlByDate.action")
    public @ResponseBody List<LinGan> getSumDlByDate(HttpServletResponse response,String startDate,String endDate){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<LinGan> list=linGanService.getSumDetailListByDate(startDate, endDate);
        return  list;
    }
}
