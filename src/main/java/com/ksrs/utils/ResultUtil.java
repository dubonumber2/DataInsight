package com.ksrs.utils;


import com.ksrs.VO.ResultVO;

public class ResultUtil {
    public static ResultVO success(Object o){
        ResultVO result=new ResultVO();
        result.setData(o);
        result.setCode(400);
        result.setMsg("成功");
        return result;
    }
    public static ResultVO success(){

        return success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO result=new ResultVO();

        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
