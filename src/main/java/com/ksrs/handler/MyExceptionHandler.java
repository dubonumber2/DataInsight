package com.ksrs.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.ksrs.enums.ResultEnum;
import com.ksrs.exception.MyException;
import com.ksrs.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        MyException myException = null;
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof MyException){
            myException = (MyException) e;
            try {
                httpServletResponse.getWriter().print(ResultUtil.error(myException.getCode(),myException.getMessage()).toString());
            } catch (IOException e1) {
                logger.error("通讯发生异常：{}",e1);
            }

        }else{
            logger.error("【系统异常】={}",e);
            try {

                httpServletResponse.getWriter().print(ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode(),ResultEnum.UNKNOW_ERROR.getMsg()).toString());
            } catch (IOException e1) {
                logger.error("通讯发生异常：{}",e1);
            }
        }
        return modelAndView;


    }

}
