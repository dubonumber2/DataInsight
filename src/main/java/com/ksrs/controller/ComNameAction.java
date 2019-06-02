package com.ksrs.controller;

import com.ksrs.VO.ResultVO;
import com.ksrs.entity.ComName;
import com.ksrs.entity.MongoStatistics;
import com.ksrs.entity.ZqDataSource;
import com.ksrs.service.ComNameService;
import com.ksrs.service.MongoStatisticsService;
import com.ksrs.utils.LayUiUtils;
import com.ksrs.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
@RequestMapping("/comname")
@Controller
public class ComNameAction {
    @Autowired
    ComNameService comNameService;
    @Autowired
    MongoStatisticsService mongoStatisticsService;

    public void setMongoStatisticsService(MongoStatisticsService mongoStatisticsService) {
        this.mongoStatisticsService = mongoStatisticsService;
    }

    public void setComNameService(ComNameService comNameService) {
        this.comNameService = comNameService;
    }
    @RequestMapping("/getAllName.action")
    public @ResponseBody List<ComName> getAllName(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ComName> list=comNameService.getAllName();
        return list;
    }
    @RequestMapping("/getJxName.action")
    public  @ResponseBody List<ComName> getJxName(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ComName> list=comNameService.getJxName();
        return list;
    }
    @RequestMapping("/getDataSource.action")
    public @ResponseBody List<ComName> getDataSource(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ComName> list=comNameService.getDataSource(null);
        return list;
    }
    @RequestMapping("/getJxSource.action")
    public @ResponseBody List<ComName> getJxSource(){
        List<ComName> list=comNameService.getJxSource();
        return list;
    }
    @RequestMapping("/getDataSourcewh.action")
    public @ResponseBody LayUiUtils getDataSourcewh(HttpServletResponse response,String ziduan){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        if("undefinded".equals(ziduan)){
            ziduan="";
        }
        List<ComName> list=comNameService.getDataSource(ziduan);
        LayUiUtils lay=new LayUiUtils();
        lay.setData(list);
        lay.setMsg(",");
        lay.setCode(0);
        return lay;
    }
    @RequestMapping("/insertDataSource.action")
    public void insertDataSource(HttpServletResponse response, ZqDataSource ZqDataSource) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            comNameService.insertDataSource(ZqDataSource);

            out.print("success");
        }catch (Exception e){
            e.printStackTrace();
            out.print("faile");
        }finally {
            out.close();
        }

    }
    @RequestMapping("/insertJxDataSource.action")
    public void insertJxDataSource(HttpServletResponse response, ComName comName) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String dataSource = comName.getName();
        String describe = comName.getDescribe();
        PrintWriter out = response.getWriter();
        try {
            comNameService.insertJxDataSource(dataSource, describe);

            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("faile");
        } finally {
            out.close();
        }
    }
    @RequestMapping("/getJxDataSourceWh.action")
    public @ResponseBody LayUiUtils getJxDataSourceWh(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ComName> list=comNameService.getJxSource();
        LayUiUtils lay=new LayUiUtils();
        lay.setData(list);
        lay.setMsg(",");
        lay.setCode(0);
        return lay;
    }
    @RequestMapping("/getMongoSource.action")
    public @ResponseBody LayUiUtils getMongoSource(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<MongoStatistics> list=mongoStatisticsService.getAll();
        LayUiUtils lay=new LayUiUtils();
        lay.setData(list);
        lay.setMsg(",");
        lay.setCode(0);
        return lay;
    }
    @RequestMapping("/insertMongoSource.action")
    public void insertMongoSource(HttpServletResponse response, MongoStatistics mongoStatistics) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
           mongoStatisticsService.insertData(mongoStatistics);
            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("faile");
        } finally {
            out.close();
        }
    }
    @RequestMapping("/getClueminingCompany.action")
    public  @ResponseBody List<ComName> getClueCom(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ComName> list=comNameService.getClueminCompany();
        return list;
    }
    @RequestMapping(value = "/updateSource.action",method = RequestMethod.POST)
    public @ResponseBody ResultVO<ZqDataSource> updateSource(HttpServletResponse response,ZqDataSource zqDataSource){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        comNameService.updateData(zqDataSource);
        ResultVO a=new ResultVO();
        a.setCode(200);
        a.setMsg("success");
        a.setData(zqDataSource);
        return a;
    }
    @RequestMapping("/getpcpname.action")
    public @ResponseBody ResultVO getPcpName(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("success");
        resultVO.setData(comNameService.getPcpName());
        return  resultVO;
    }
}
