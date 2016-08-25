package com.app.controller;

import com.app.constant.Constant;
import com.app.model.Platform;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Jerry on 16/8/24.
 */
public class Base {

    /**
     * 获取IP地址
     * @return IP
     */
    public String getIP(){
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取Cookie值
     * @param cookieName
     * @return
     */
    protected String getCookieValue(String cookieName)
    {
        HttpServletRequest request = getRequest();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies)
        {
            for(Cookie cookie:cookies)
            {
                if(cookie.getName().equals(cookieName))
                {
                    return cookie.getValue();
                }
            }
        }
        return Constant.EMPTY;
    }

    /**
     * 获取请求设备
     * @return
     */
    protected Platform getPlatform(){
        HttpServletRequest request = getRequest();
        String client = request.getHeader("User-Agent");
        Platform pf = Platform.PC;
        if (client.contains("iPhone")) {
            pf = Platform.IOS;
        } else if (client.contains("Android")){
            pf = Platform.Android;
        }
        return pf;
    }

    /**
     * 获取Request
     * @return
     */
    protected HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取Response
     * @return
     */
    protected HttpServletResponse getResponse(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取Session
     * @return
     */
    protected HttpSession getSession(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
    }
}
