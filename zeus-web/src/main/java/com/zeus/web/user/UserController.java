package com.zeus.web.user;

import com.zeus.user.api.domain.User;
import com.zeus.user.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author keven
 * @date 2018-02-10 下午4:22
 * @Description
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("api/user/find-by-id")
    public User findUserById(Long id) {
        return userService.findByMail("12");
    }
}
