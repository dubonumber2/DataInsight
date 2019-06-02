package com.ksrs.utils;

import com.ksrs.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

                HttpServletRequest servletRequest = (HttpServletRequest) request;
                HttpServletResponse servletResponse = (HttpServletResponse) response;
                HttpSession session = servletRequest.getSession();
                String path=servletRequest.getRequestURI();
                User user=(User)session.getAttribute("user");
                String login="/login.html";
                if(path.indexOf(login)>-1){
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
                if(user==null){
                    servletResponse.sendRedirect(login);
                }else{
                    filterChain.doFilter(servletRequest,servletResponse);
                }
    }

    @Override
    public void destroy() {

    }
}
