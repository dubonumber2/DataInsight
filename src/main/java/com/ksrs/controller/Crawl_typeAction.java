package com.ksrs.controller;


import com.ksrs.service.Crawl_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Controller
@RequestMapping("/crawl")
public class Crawl_typeAction {



    @Autowired
    private Crawl_typeService crawl_typeService;

   /* @RequestMapping("/getAll.action")
    public @ResponseBody LayUiUtils getAll(HttpServletRequest request, HttpServletResponse response){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<Crawl_type> list=crawl_typeService.getAll();
        LayUiUtils lay=new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        lay.setCount(1000);
        lay.setData(list);

        return lay;
    }*/
    public void setCrawl_typeService(Crawl_typeService crawl_typeService) {
        this.crawl_typeService = crawl_typeService;
    }
}
