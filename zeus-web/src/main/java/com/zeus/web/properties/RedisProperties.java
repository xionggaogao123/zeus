package com.zeus.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author keven
 * @date 2018-01-15 下午2:32
 * @Description
 */
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisProperties {

    private String host;
    private int port = 6379;
    private int maxTotal = 5;
    private int maxIdle = 0;
    private int maxWaitMillis = 10000;
    private boolean testOnBorrow = true;
    private boolean cluster = false;
    private String auth;
    private String sentinelHosts;
    private String sentinelMasterName;
}
