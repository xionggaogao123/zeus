package com.zeus.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.zeus.web.properties.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
@ComponentScan({"com.zeus"})
@Import(RedisAutoConfiguration.class)
public class WebConfiguration {

    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public EventBus eventBus() {
        return new AsyncEventBus(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

}
