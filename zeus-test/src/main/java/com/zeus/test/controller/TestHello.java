package com.zeus.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author keven
 * @date 2018-01-12 下午11:07
 * @Description
 */
@Controller
public class TestHello {


    /***
     * 200 2.16
     * 2000 21.6
     * 20000 216
     */


    @RequestMapping("/hello")
    public String testHello(Model model) {
        return "hello";
    }



}
