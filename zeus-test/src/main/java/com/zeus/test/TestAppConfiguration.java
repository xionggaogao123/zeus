package com.zeus.test;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.zeus.test.filter.SessionFilter;
import com.zeus.test.interceptor.AuthInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.concurrent.Executors;

/**
 * @author keven
 * @date 2018-01-17 上午11:29
 * @Description
 */
@EnableWebMvc
@EnableAutoConfiguration
@EnableScheduling
@Configuration
@ComponentScan({"com.zeus.test"})
@EnableAspectJAutoProxy
public class TestAppConfiguration  extends WebMvcConfigurerAdapter {


    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(sessionFilter());

        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("testFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter sessionFilter() {
        return new SessionFilter();
    }

    @Bean
    public EventBus eventBus() {
        return new AsyncEventBus(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加权限拦截器
        registry.addInterceptor(getAuthInterceptor());
        //添加登录拦截器

    }

    @Bean
    public AuthInterceptor getAuthInterceptor() {
        return new AuthInterceptor();
    }



}
