package com.zeus.web.redis;


public class RedisConstants {

    /**
     * 项目前缀
     */
    private static final String PROJECT_PREFIX = "WEBAPP:";
    /**
     * 登录重试次数REDIS标记
     */
    public static final String PREFIX_LOGIN_RETRY_TIMES = PROJECT_PREFIX + "LOGIN_RETRY_TIMES:";
    /**
     * IP信息标记
     */
    public static final String PREFIX_IP_INFO = PROJECT_PREFIX + "IP_INFO:";
    /**
     * REDIS锁标记
     */
    public static final String REDIS_PREFIX_LOCK = PROJECT_PREFIX + "LOCK:";
    /**
     * REDIS升级锁标记
     */
    public static final String REDIS_PREFIX_LEVEL_UP_LOCK = REDIS_PREFIX_LOCK + "USER:LEVEL_UP:";

}
