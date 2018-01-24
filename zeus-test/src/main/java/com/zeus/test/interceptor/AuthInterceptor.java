package com.zeus.test.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author keven
 * @date 2018-01-17 下午2:30
 * @Description 权限 拦截器
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("权限拦截器 实现 ....");
        return true;
    }

}
