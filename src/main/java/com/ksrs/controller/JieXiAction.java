package com.ksrs.controller;

import com.ksrs.entity.JieXi;
import com.ksrs.service.JieXiService;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
@Controller
@RequestMapping("/jiexi")
public class JieXiAction {
    @Autowired
    JieXiService jieXiService;

    public void setJieXiService(JieXiService jieXiService) {

        this.jieXiService = jieXiService;
    }
    @RequestMapping("/getdate.action")
    public @ResponseBody LayUiUtils getDate(HttpServletResponse response, String date,int limit,int page){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        if(date==null|| "".equals(date)){
            List<JieXi> list=jieXiService.getData(page,limit);
            int total=jieXiService.getTotal();
            lay.setCount(total);
            lay.setData(list);

        }else{

            List<JieXi> list=jieXiService.getDate(date,page,limit);
            int total=jieXiService.getTotalByDate(date);
            lay.setCount(total);
            lay.setData(list);
        }

        return lay;
    }
    @RequestMapping("/getsum.action")
    public void getSumByDate(HttpServletResponse response,String date){

          long a=jieXiService.getSumByDate(date);
        PrintWriter out=null;
        try {
             out=response.getWriter();
            out.print(a);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
    }
}
