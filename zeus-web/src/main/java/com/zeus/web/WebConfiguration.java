package com.zeus.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.zeus.common.interceptor.CommonInterceptor;
import com.zeus.user.impl.UserConfiguration;
import com.zeus.web.component.captcha.CaptchaGenerator;
import com.zeus.web.component.captcha.DefaultCaptchaGenerator;
import com.zeus.web.properties.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Executors;

/**
 * @author keven
 * @date 2018-01-15 下午2:25
 * @Description
 */
@EnableWebMvc
@EnableAutoConfiguration
@EnableScheduling
@Configuration
@ComponentScan({"com.zeus.web"})
@Import({RedisAutoConfiguration.class, UserConfiguration.class})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor());
    }


    @Bean
    public EventBus eventBus() {
        return new AsyncEventBus(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    @Bean
    @ConditionalOnMissingBean(CaptchaGenerator.class)
    public CaptchaGenerator captchaGenerator () {
        return new DefaultCaptchaGenerator();
    }
}
