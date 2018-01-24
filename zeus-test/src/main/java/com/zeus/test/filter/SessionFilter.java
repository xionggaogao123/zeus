package com.zeus.test.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author keven
 * @date 2018-01-17 下午2:18
 * @Description session 过滤器
 */
public class SessionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("TestFilter .....");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
