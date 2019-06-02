package com.ksrs.controller;

import com.ksrs.entity.Result;
import com.ksrs.service.ResultService;
import com.ksrs.utils.DowloadUtils;
import com.ksrs.utils.DowloadUtils2;
import com.ksrs.utils.LayUiUtils;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.tools.classfile.Attribute.Exceptions;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@Controller
@RequestMapping("/result")
public class ResultAction {
    @Autowired
    private ResultService resultService;

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }
    @RequestMapping("/getPage.action")
    public @ResponseBody
    LayUiUtils getPage(HttpServletResponse response,int limit,int page,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        List<Result> list=resultService.getPage(page,limit);
        int total=resultService.getTotal();
        lay.setCount(total);
        lay.setMsg(",");
        lay.setCode(0);
        lay.setData(list);
        System.out.println("准备发射");
        if("dowload".equals(dowload)){
            System.out.println("y发射");
            DowloadUtils.dowload(response,list);
        }
        return lay;
    }
    @RequestMapping("/getByDate.action")
    public @ResponseBody LayUiUtils getByDate(HttpServletResponse response,String stardate,String enddate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        List<Result> list=resultService.getDataByDate(stardate, enddate);
        lay.setCount(resultService.getTotalByDate(stardate, enddate));
        lay.setData(list);
        lay.setCode(0);
        lay.setMsg(",");
        if("dowload".equals(dowload)){
            DowloadUtils.dowload(response,list);
        }
        return lay;
    }
    @RequestMapping("/getGongs.action")
    public @ResponseBody LayUiUtils getGongS(HttpServletResponse response,int limit,int page,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        List<Result> list=resultService.getGongS(page,limit);
        int total=resultService.getTotal();
        lay.setCount(total);
        lay.setMsg(",");
        lay.setCode(0);
        lay.setData(list);
        if("dowload".equals(dowload)){
            DowloadUtils2.dowload(response,list);
        }
        return lay;

    }
    @RequestMapping("/getGongsBydate.action")
    public @ResponseBody LayUiUtils getGongSByDate(HttpServletResponse response,String enddate,String dowload){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        lay.setCount(resultService.getTotal());
        lay.setData(resultService.getGongSByDate(enddate));
        if("dowload".equals(dowload)){
            DowloadUtils2.dowload(response,resultService.getGongSByDate(enddate));
        }
        return  lay;
    }


}
