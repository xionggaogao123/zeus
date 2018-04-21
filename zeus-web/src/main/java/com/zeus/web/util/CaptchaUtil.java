package com.zeus.web.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Properties;
import java.util.Random;

/**
 * @author keven
 * @date 2018-04-21 下午1:09
 * @Description  验证码生成器
 */
@Slf4j
public class CaptchaUtil {

    private static DefaultKaptcha INSTANCE;

    private static final char[] DICT = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    static {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "170");
        properties.setProperty("kaptcha.image.height", "80");
        properties.setProperty("kaptcha.textproducer.font.color", "13,78,0");
        properties.setProperty("kaptcha.noise.color", "13,78,0");
        INSTANCE = new DefaultKaptcha();
        INSTANCE.setConfig(new Config(properties));
    }

    public static String generateCaptcha(String captchaId, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        try {
            String code = getRandomCode(5);
            BufferedImage image = INSTANCE.createImage(code);
            ImageIO.write(image, "jpg", response.getOutputStream());
            //TODO 放入缓存
            return code;
        } catch (Exception e) {
            log.error("generate captcha error.", e);
        }
        return null;
    }

    private static String getRandomCode(int num) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            code.append(DICT[random.nextInt(DICT.length)]);
        }
        return code.toString();
    }

}
