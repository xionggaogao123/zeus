package com.zeus.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author keven
 * @date 2018-04-16 下午2:06
 * @Description
 */
@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.run(args);
    }
}
