package com.zeus.web.user;

import com.google.common.base.CharMatcher;
import com.zeus.user.api.constant.LoginType;
import com.zeus.user.api.domain.User;
import com.zeus.user.api.service.UserService;
import com.zeus.web.component.captcha.CaptchaGenerator;
import com.zeus.web.util.CaptchaUtil;
import com.zeus.web.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author keven
 * @date 2018-02-10 下午4:22
 * @Description
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private CaptchaGenerator captchaGenerator;


    @GetMapping("api/user/find-by-id")
    public User findUserById(Long id) {
        return userService.findByMail("12");
    }


    /**
     * 生成图片验证码， 方式一
     */
    @GetMapping("api/web/user/login/getCaptcha")
    public void generateCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            String deviceId = CookieUtil.getDeviceCookie(request);
            CaptchaUtil.generateCaptcha(deviceId, request, response);
        }catch (Exception e) {
            log.error("generate captcha fail");
        }
    }

    /**
     * 生成图片验证码， 方式二
     */
    @GetMapping("api/web/user/captcha")
    public ResponseEntity<byte[]> getCaptcha(HttpServletRequest request) {
        byte[] imgCache;
        HttpSession session = request.getSession();
        imgCache = captchaGenerator.generateCaptcha(session);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imgCache, headers, HttpStatus.CREATED);
    }




    /**
     * web 端 用户登录
     */
    @PostMapping("api/web/user/login")
    public User login(String username, String password) {

        LoginType loginType;
        if (CharMatcher.DIGIT.matchesAllOf(username)) {
            loginType = LoginType.MOBILE;
        }else if (CharMatcher.is('@').matchesAnyOf(username)) {
            loginType = LoginType.EMAIL;
        }else {
            loginType = LoginType.NAME;
        }



        return null;
    }

}
