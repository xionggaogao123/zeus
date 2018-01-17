package com.zeus.web.test;

import com.zeus.common.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @author keven
 * @date 2018-01-15 下午2:17
 * @Description
 */
@RestController
public class TestRedis {

    @Autowired
    private JedisTemplate jedisTemplate;


    @RequestMapping("api/redis/hello")
    public String testJedis() {
        setValue("hello", "world");
        String value = getValue("hello");
        System.out.println("value: " + value);
        return value;
    }

    public void setValue(String key, String value) {
        jedisTemplate.execute((Jedis jedis) -> jedis.set(key, value));
    }

    public String getValue(String key) {
        return jedisTemplate.execute((Jedis jedis) -> jedis.get(key));
    }
}
