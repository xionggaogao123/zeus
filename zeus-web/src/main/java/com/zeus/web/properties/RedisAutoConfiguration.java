package com.zeus.web.properties;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.zeus.common.redis.JedisTemplate;
import com.zeus.common.util.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

import java.util.Set;

/**
 * @author keven
 * @date 2018-01-15 下午2:36
 * @Description
 */
@Configuration
@EnableConfigurationProperties({RedisProperties.class})
public class RedisAutoConfiguration {

    private final RedisProperties properties;

    @Autowired
    public RedisAutoConfiguration(RedisProperties properties) {
        this.properties = properties;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(this.properties.getMaxTotal());
        config.setMaxIdle(this.properties.getMaxIdle());
        config.setMaxWaitMillis((long) this.properties.getMaxWaitMillis());
        config.setTestOnBorrow(this.properties.isTestOnBorrow());
        return config;
    }

    @Bean
    public Pool<Jedis> jedisPool(JedisPoolConfig poolConfig) {
        if (this.properties.isCluster()) {
            String sentinelProps = this.properties.getSentinelHosts();
            Iterable<String> parts = Splitter.on(',').trimResults().omitEmptyStrings().split(sentinelProps);
            Set<String> sentinelHosts = Sets.newHashSet(parts);
            String masterName = this.properties.getSentinelMasterName();
            return Arguments.isEmpty(this.properties.getAuth()) ? new JedisSentinelPool(masterName, sentinelHosts, poolConfig) : new JedisSentinelPool(masterName, sentinelHosts, poolConfig, 2000, this.properties.getAuth());
        } else {
            return Arguments.isEmpty(this.properties.getAuth()) ? new JedisPool(poolConfig, this.properties.getHost(), this.properties.getPort()) : new JedisPool(poolConfig, this.properties.getHost(), this.properties.getPort(), 2000, this.properties.getAuth());
        }
    }

    @Bean
    public JedisTemplate jedisTemplate(Pool<Jedis> pool) {
        return new JedisTemplate(pool);
    }

}
