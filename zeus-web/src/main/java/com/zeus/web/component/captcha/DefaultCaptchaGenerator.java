package com.zeus.web.component.captcha;

import com.github.cage.Cage;
import com.github.cage.IGenerator;
import com.github.cage.image.EffectConfig;
import com.github.cage.image.Painter;
import com.github.cage.token.RandomTokenGenerator;
import javax.annotation.PostConstruct;

/**
 * @author keven
 * @date 2018-04-21 下午1:48
 * @Description
 */
public class DefaultCaptchaGenerator extends CaptchaGenerator{

    private IGenerator<String> tokenGenerator;

    @PostConstruct
    public void init() {
        Painter painter = new Painter(150, 70, null, null, new EffectConfig(true, true, true, true, null), null);
        tokenGenerator = new RandomTokenGenerator(null, 4, 0);
        cage = new Cage(painter, null, null, null, Cage.DEFAULT_COMPRESS_RATIO, tokenGenerator, null);
    }

    @Override
    public String generateCaptchaToken() {
        return tokenGenerator.next() ;
    }
}
