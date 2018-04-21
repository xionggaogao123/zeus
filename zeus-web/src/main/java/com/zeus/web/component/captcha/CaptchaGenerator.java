package com.zeus.web.component.captcha;

import com.github.cage.Cage;

import javax.servlet.http.HttpSession;
import javax.swing.*;

/**
 * @author keven
 * @date 2018-04-21 下午1:43
 * @Description  验证码 基类
 */
public abstract class CaptchaGenerator {


    protected static final String CAPTCHA_TOKEN = "captchaToken";

    protected Cage cage;

    public abstract  String generateCaptchaToken();

    public byte[] captcha(String token) {
        return cage.draw(token);
    }

    public byte[] generateCaptcha(HttpSession session) {
        String token = cage.getTokenGenerator().next();
        session.setAttribute(CAPTCHA_TOKEN, token);
        return cage.draw(token);
    }


    public String getGeneratedKey(HttpSession session) {
        String token = (String) session.getAttribute(CAPTCHA_TOKEN);
        session.removeAttribute(CAPTCHA_TOKEN);
        return token;
    }

}
