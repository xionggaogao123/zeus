package com.zeus.web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author keven
 * @date 2018-01-15 下午2:27
 * @Description
 */
@RestController
public class TestController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("api/test")
    public String testHello() {

        Integer integer = 1;
        return "hello world";
    }
}
