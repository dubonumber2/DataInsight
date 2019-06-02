package com.ksrs.controller;

import com.ksrs.entity.ElasticSearchEntity;
import com.ksrs.service.ElasticSearchService;
import com.ksrs.utils.LayUiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/esearch")
public class ElasticSearchAction {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @RequestMapping("/getData.action")
    public @ResponseBody
    LayUiUtils getAll(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        List<ElasticSearchEntity> list=elasticSearchService.getNews();
        LayUiUtils lay = new LayUiUtils();
        lay.setCode(0);
        lay.setMsg(",");
        lay.setData(list);
        return lay;
    }
}
