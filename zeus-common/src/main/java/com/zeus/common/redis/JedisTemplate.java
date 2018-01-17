package com.zeus.common.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.Pool;

/**
 * @author keven
 * @date 2018-01-15 上午11:59
 * @Description
 */
@Slf4j
public class JedisTemplate {

    private Pool<Jedis> jedisPool;

    public JedisTemplate(Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
    }

    public <T> T execute(JedisTemplate.JedisAction<T> jedisAction) throws JedisException {
        return (T)this.execute((JedisTemplate.JedisAction)jedisAction, 0);
    }

    public <T> T execute(JedisTemplate.JedisAction<T> jedisAction, int dbIndex) throws JedisException {
        Jedis jedis = null;
        boolean broken = false;

        Object var5;
        try {
            jedis = (Jedis)this.jedisPool.getResource();
            jedis.select(dbIndex);
            var5 = jedisAction.action(jedis);
        } catch (JedisConnectionException var9) {
            log.error("Redis connection lost.", var9);
            broken = true;
            throw var9;
        } finally {
            this.closeResource(jedis, broken);
        }

        return (T)var5;
    }

    public void execute(JedisTemplate.JedisActionNoResult jedisAction) throws JedisException {
        this.execute((JedisTemplate.JedisActionNoResult)jedisAction, 0);
    }

    public void execute(JedisTemplate.JedisActionNoResult jedisAction, int dbIndex) throws JedisException {
        Jedis jedis = null;
        boolean broken = false;

        try {
            jedis = (Jedis)this.jedisPool.getResource();
            jedis.select(dbIndex);
            jedisAction.action(jedis);
        } catch (JedisConnectionException var9) {
            log.error("Redis connection lost.", var9);
            broken = true;
            throw var9;
        } finally {
            this.closeResource(jedis, broken);
        }

    }

    protected void closeResource(Jedis jedis, boolean connectionBroken) {
        if(jedis != null) {
            if(connectionBroken) {
                this.jedisPool.returnBrokenResource(jedis);
            } else {
                this.jedisPool.returnResource(jedis);
            }
        }

    }

    public Pool<Jedis> getJedisPool() {
        return this.jedisPool;
    }


    public interface JedisAction<T> {
        T action(Jedis var1);
    }

    public interface JedisActionNoResult {
        void action(Jedis var1);
    }

}
