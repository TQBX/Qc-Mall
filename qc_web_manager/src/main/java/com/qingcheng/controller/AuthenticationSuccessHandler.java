package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.system.LoginLog;
import com.qingcheng.service.system.LoginLogService;
import com.qingcheng.util.WebUtil;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Summerday
 */
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Reference
    private LoginLogService loginLogService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //登录后调用
        System.out.println("登录成功...记录日志...");
        LoginLog loginLog = new LoginLog();
        String ip = httpServletRequest.getRemoteAddr();
        String agent = httpServletRequest.getHeader("user-agent");

        loginLog.setLoginName(authentication.getName());//当前登录用户名
        loginLog.setLoginTime(new Date());//登录时间
        loginLog.setIp(ip);//远程客户端ip
        loginLog.setLocation(WebUtil.getCityByIP(ip));//地区
        loginLog.setBrowserName("");//浏览器名称
        loginLog.setBrowserName(WebUtil.getBrowserName(agent));

        loginLogService.add(loginLog);

        httpServletRequest.getRequestDispatcher("/main.html").forward(httpServletRequest,httpServletResponse);
    }
}
