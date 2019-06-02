package com.ksrs.controller;

import com.ksrs.entity.ZheXianJx;
import com.ksrs.service.ZheXianJxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/10/19 0019.
 */
@Controller
@RequestMapping("/zhexianjx")
public class ZheXianJxAction {
    @Autowired
    ZheXianJxService zheXianJxService;

    public void setZheXianJxService(ZheXianJxService zheXianJxService) {
        this.zheXianJxService = zheXianJxService;
    }
    @RequestMapping("/getjxDate.action")
    public @ResponseBody
    ZheXianJx getDate(){
        ZheXianJx zheXianJx=zheXianJxService.getDate();
        return zheXianJx;
    }
    @RequestMapping("/getjxbn.action")
    public @ResponseBody ZheXianJx getDateByName(String name){
        ZheXianJx zheXianJx=null;
        if(name==null|| "".equals(name)){
            zheXianJx=zheXianJxService.getDate();
        }else{
            zheXianJx=zheXianJxService.getDateByName(name);
        }
        return zheXianJx;
    }
}
