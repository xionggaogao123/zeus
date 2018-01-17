package com.zeus.web.redis;

import com.zeus.common.redis.JedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

/**
 * @author keven
 * @date 2018-01-15 下午3:12
 * @Description
 */
@Slf4j
@Service
public class RedisManager {

    private final JedisTemplate jedisTemplate;

    @Autowired
    public RedisManager(JedisTemplate jedisTemplate) {
        this.jedisTemplate = jedisTemplate;
    }

    /**
     * 设值，无失效时间
     *
     * @param key   唯一标记
     * @param value 值
     */
    public void setValue(String key, String value) {
        jedisTemplate.execute((Jedis jedis) -> jedis.set(key, value));
    }

    /**
     * 设值
     *
     * @param key     唯一标记
     * @param value   值
     * @param seconds 过期时间
     */
    public void setValue(String key, String value, int seconds) {
        jedisTemplate.execute((Jedis jedis) -> {
            jedis.set(key, value);
            jedis.expire(key, seconds);
        });
    }

    /**
     * 取值
     *
     * @param key 唯一标记
     * @return String
     */
    public String getValue(String key) {
        return jedisTemplate.execute((Jedis jedis) -> jedis.get(key));
    }

    /**
     * 设值过期时间
     *
     * @param key     唯一标记
     * @param seconds 过期时间
     */
    public void expire(String key, int seconds) {
        jedisTemplate.execute((Jedis jedis) -> jedis.expire(key, seconds));
    }

    /**
     * 删除
     *
     * @param key 唯一标记
     */
    public void del(String key) {
        jedisTemplate.execute((Jedis jedis) -> jedis.del(key));
    }


    /**
     * 全局加锁
     *
     * @param key        key
     * @param expireTime 超时时间 单位：秒
     * @return lock value
     */
    public String lock(String key, Long expireTime) {
        String lockKey = RedisConstants.REDIS_PREFIX_LOCK + key;
        String value = System.currentTimeMillis() + "random";
        jedisTemplate.execute((Jedis jedis) -> {
            String status = jedis.set(lockKey, value, "nx", "ex", expireTime);
            while (!"OK".equals(status)) {
                try {
                    Thread.sleep(2);
                    status = jedis.set(lockKey, value, "nx", "ex", expireTime);
                } catch (InterruptedException e) {
                    log.error("redis add lock error.", e);
                }
            }
        });
        return value;
    }

    /**
     * 解锁
     *
     * @param key       key
     * @param lockValue 用lockValue判断当前锁是否还是自己的
     */
    public void unlock(String key, String lockValue) {
        String lockKey = RedisConstants.REDIS_PREFIX_LOCK + key;
        String script = "if redis.call('get','" + lockKey + "') == '" + lockValue + "' then\n"
                + "return redis.call('del','" + lockKey + "')"
                + "else\n"
                + "    return 0\n"
                + "end";
        jedisTemplate.execute((Jedis jedis) -> jedis.eval(script));
    }

    public <T> T execute(JedisTemplate.JedisAction<T> jedisAction) throws JedisException {
        return jedisTemplate.execute(jedisAction, 0);
    }
}
