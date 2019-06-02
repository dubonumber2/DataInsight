package com.ksrs.controller;

import com.ksrs.VO.ResultVO;
import com.ksrs.entity.User_operation;
import com.ksrs.enums.ResultEnum;
import com.ksrs.exception.MyException;
import com.ksrs.service.ClueminingPcpService;
import com.ksrs.utils.LayUiUtils;
import com.ksrs.utils.PcpDowload;
import com.ksrs.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/pcp")
public class ClueminingPcpController {
    @Autowired
    private ClueminingPcpService clueminingPcpService;

    @ResponseBody
    @RequestMapping("/get.action")
    public LayUiUtils getPcpData(HttpServletResponse response, String operation_name, String end_time, String operation_time, String user_name, String user_company, String realname, String user_type, String dowload, int page, int limit){
        LayUiUtils lay = new LayUiUtils();
        List<User_operation> list = clueminingPcpService.getByOpName(operation_time,
                end_time,operation_name,user_name,user_company,realname,user_type,page,limit);

        int total = clueminingPcpService.getTotal(operation_time, end_time, operation_name, user_name, user_company, realname, user_type);
        if(list == null){
            LayUiUtils lay1= new LayUiUtils();
            lay1.setCode(-1);
            lay1.setMsg("无数据");
            return lay1;
        }
        if("true".equals(dowload)){
            list = clueminingPcpService.getByOpName(operation_time,
                    end_time,operation_name,user_name,user_company,realname,user_type,page,total);
            if(list.size()>0){
                PcpDowload.dowload(response,list);
            }else{
                throw new MyException(ResultEnum.IS_NULL);
            }
            //PcpDowload.dowload(response,list);
        }
        lay.setData(list);
        lay.setMsg(",");
        lay.setCode(0);
        lay.setCount(total);
        return lay;
    }
}
