package com.ksrs.controller;

import com.ksrs.entity.ComName;
import com.ksrs.entity.LogsModel;
import com.ksrs.service.ComNameService;
import com.ksrs.service.LogsModelService;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
@Controller
@RequestMapping("/getLogs")
public class LogsModelAction {
    @Autowired
    private LogsModelService logsModelService;
    @Autowired
    private ComNameService comNameService;

    public void setComNameService(ComNameService comNameService) {
        this.comNameService = comNameService;
    }

    public void setLogsModelService(LogsModelService logsModelService) {
        this.logsModelService = logsModelService;
    }

    @RequestMapping("/getDefault.action")
    public @ResponseBody LayUiUtils getDefault(int page, int limit, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Date date = new Date();
        Date yesterday = new Date(date.getTime() - 86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = sdf.format(yesterday);
        List<LogsModel> list=logsModelService.getDefault(page,limit,endDate,endDate);

        Map<String,Integer> map=new HashMap<>();
        List<ComName> list1=comNameService.getDataSource(null);
        for(int i=0;i<list.size();i++){
            map.put(list.get(i).getDataSource(),1);
        }
        for(int i=0;i<list1.size();i++){
            if(!map.containsKey(list1.get(i).getName())){
                LogsModel a=new LogsModel();
                a.setDataSource(list1.get(i).getName());
                a.setCountTime(endDate);
                a.setHttpCounts(0);
                a.setYxCounts(0);
                a.setZqCounts(0);
                list.add(a);
            }
        }
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        lay.setCount(list1.size());
        lay.setData(list);
        return lay;
    }

    @RequestMapping("/getByDate.action")
    public @ResponseBody LayUiUtils getByDate(int page,int limit,String endDate){
        List<LogsModel> list=logsModelService.getDefault(page,limit,endDate,endDate);
        Map<String,Integer> map=new HashMap<>();
        List<ComName> list1=comNameService.getDataSource("");
        for(int i=0;i<list.size();i++){
            map.put(list.get(i).getDataSource(),1);
        }
        for(int i=0;i<list1.size();i++){
            if(!map.containsKey(list1.get(i).getName())){
                LogsModel a=new LogsModel();
                a.setDataSource(list1.get(i).getName());
                a.setCountTime(endDate);
                a.setHttpCounts(0);
                a.setYxCounts(0);
                a.setZqCounts(0);
                list.add(a);
            }
        }
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        lay.setCount(list1.size());
        lay.setData(list);
        return lay;
    }

    @RequestMapping("/getByName.action")
    public @ResponseBody LayUiUtils getByName(int page,int limit,String endDate,String comName){
            List<LogsModel> list = logsModelService.getByName(endDate, endDate, comName, page, limit);
            LayUiUtils lay = new LayUiUtils();
            lay.setCode(0);
            lay.setMsg(",");
            lay.setCount(list.size());
            lay.setData(list);

        return lay;
    }
    @RequestMapping("/getLogsPic.action")
    public @ResponseBody List<LogsModel> getLogsPic(String comName){
        Date date=new Date();
        long day=date.getTime();
        long ago=day-(86400000L*7);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String starDate=simpleDateFormat.format(day);
        String endDate=simpleDateFormat.format(ago);
        List<LogsModel> list = logsModelService.getByName1(endDate, starDate, comName);
        return list;
    }
    @RequestMapping("/getLogsPicByDate.action")
    public @ResponseBody List<LogsModel> getLogsPicByDate(String starDate,String endDate,String comName){

        List<LogsModel> list = logsModelService.getByName1(starDate,endDate,comName);
        return list;
    }

    @RequestMapping("/getLogsJx.action")
    public @ResponseBody LayUiUtils getLogsJx(int limit,int page){
        Date date = new Date();
        Date yesterday = new Date(date.getTime() - 86400000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = sdf.format(yesterday);
        LayUiUtils layUiUtils=new LayUiUtils();
        List<LogsModel> list=logsModelService.getJxDefault(endDate,endDate,page,limit,"");
        int total=logsModelService.getJxDefaultTotal(endDate,endDate,"");
        layUiUtils.setCount(total);
        layUiUtils.setData(list);
        layUiUtils.setMsg(",");
        layUiUtils.setCode(0);
        return  layUiUtils;
    }
    @RequestMapping("/getLogsJxByDate.action")
    public @ResponseBody LayUiUtils getLogsJxByDate(String endDate,String comName,int limit,int page){
        LayUiUtils lay=new LayUiUtils();
        List<LogsModel> list=logsModelService.getJxDefault(endDate,endDate,page,limit,comName);
        int total=logsModelService.getJxDefaultTotal(endDate,endDate,comName);
        lay.setCode(0);
        lay.setCount(total);
        lay.setMsg(",");
        lay.setData(list);
        return  lay;
    }
    @RequestMapping("/getLogsjxPic.action")
    public @ResponseBody List<LogsModel> getLogsjxPic(String comName){
        Date date=new Date();
        long day=date.getTime();
        long ago=day-(86400000L*7);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String starDate=simpleDateFormat.format(day);
        String endDate=simpleDateFormat.format(ago);
        List<LogsModel> list = logsModelService.getJxDefault(endDate, starDate,1,1000, comName);

       Collections.reverse(list);
        return list;
    }
    @RequestMapping("/getLogsjxPicByDate.action")
    public @ResponseBody List<LogsModel> getLogsjxPicByDate(String starDate,String endDate,String comName){

        List<LogsModel> list = logsModelService.getJxDefault1(starDate,endDate, comName);
        return list;
    }
}
