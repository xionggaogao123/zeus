package com.zeus.common.redis;

import com.google.common.collect.Lists;
import com.zeus.common.model.Paging;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.*;

/**
 * @author keven
 * @date 2018-01-15 下午12:02
 * @Description
 */
public abstract class BaseRedisClient {

    public BaseRedisClient() {
    }

    public static Long listLen(JedisTemplate jedisTemplate, final String key) {
        return jedisTemplate.execute(jedis -> {
            return jedis.llen(key);
        });
    }

    public static List<Long> listAllToLong(JedisTemplate jedisTemplate, final String key) {
        return jedisTemplate.execute(jedis -> {
            List<String> strVals = jedis.lrange(key, 0L, -1L);
            return Lists.transform(strVals, Long::valueOf);
        });
    }

    public static Long listRemOne(JedisTemplate jedisTemplate, String key, Object val) {
        return listRem(jedisTemplate, key, val, 1L);
    }

    public static Long listRemAll(JedisTemplate jedisTemplate, String key, Object val) {
        return listRem(jedisTemplate, key, val, 0L);
    }

    private static Long listRem(JedisTemplate jedisTemplate, final String key, final Object val, final Long count) {
        return jedisTemplate.execute(jedis -> {
            return jedis.lrem(key, count, String.valueOf(val));
        });
    }

    public static Long listRemOne(JedisTemplate jedisTemplate, List<String> keys, Object val) {
        return listRem(jedisTemplate, keys, val, 1L);
    }

    public static Long listRemAll(JedisTemplate jedisTemplate, List<String> keys, Object val) {
        return listRem(jedisTemplate, keys, val, 0L);
    }

    private static Long listRem(JedisTemplate jedisTemplate, final List<String> keys, final Object val, final Long count) {
        return jedisTemplate.execute(jedis -> {
            Pipeline p = jedis.pipelined();
            Long deleted = 0L;

            String key;
            for (Iterator var4 = keys.iterator(); var4.hasNext(); deleted = deleted + p.lrem(key, count, String.valueOf(val)).get()) {
                key = (String) var4.next();
            }

            p.sync();
            return deleted;
        });
    }

    public static Long listRem(JedisTemplate jedisTemplate, final List<String> keys, final Map<String, List<?>> keyVals) {
        return jedisTemplate.execute((Jedis jedis) -> {
            Pipeline p = jedis.pipelined();
            Long removed = 0L;

            for (Object key : keys) {
                List<?> vals = keyVals.get(key);

                for (Iterator var7 = vals.iterator(); var7.hasNext(); removed = removed + 1L) {
                    Object val = var7.next();
                    p.lrem((String) key, 1L, String.valueOf(val));
                }
            }

            p.sync();
            return removed;
        });
    }

    public static Long listRem(JedisTemplate jedisTemplate, final String key, final List<?> vals) {
        return jedisTemplate.execute(jedis -> {
            Pipeline p = jedis.pipelined();
            Long removed = 0L;
            for (Iterator var4 = vals.iterator(); var4.hasNext(); removed = removed + 1L) {
                Object val = var4.next();
                p.lrem(key, 1L, String.valueOf(val));
            }
            p.sync();
            return removed;
        });
    }

    public static List listPaging2Long(JedisTemplate jedisTemplate, final String key, final Integer offset, final Integer limit) {
        return jedisTemplate.execute(jedis -> {
            List<String> ids = jedis.lrange(key, offset, (offset + limit - 1));
            return Lists.transform(ids, s -> s == null ? null : Long.valueOf(s));
        });
    }

    public static Paging listPaging(JedisTemplate jedisTemplate, final String key, final Integer offset, final Integer limit) {
        return jedisTemplate.execute((JedisTemplate.JedisAction<Paging<Long>>) jedis -> {
            Pipeline pipeline = jedis.pipelined();
            Response<Long> r = pipeline.zcard(key);
            Response<Set<String>> i = pipeline.zrevrange(key, offset, (offset + limit - 1));
            pipeline.sync();
            Long total = r.get();
            if (total <= 0L) {
                return new Paging(0L, Collections.emptyList());
            } else {
                List<Long> ids = Lists.newArrayListWithCapacity(total.intValue());

                for (Object o : i.get()) {
                    String s = (String) o;
                    ids.add(Long.valueOf(s));
                }

                return new Paging(total, ids);
            }
        });
    }

    public static Long listAdd(JedisTemplate jedisTemplate, final List<String> keys, final String val) {
        return jedisTemplate.execute(jedis -> {
            Pipeline p = jedis.pipelined();
            Long pushed = 0L;

            for (Iterator var4 = keys.iterator(); var4.hasNext(); pushed = pushed + 1L) {
                String key = (String) var4.next();
                p.lpush(key, val);
            }
            p.sync();
            return pushed;
        });
    }

    public static Long setAdd(JedisTemplate jedisTemplate, final String key, final String val) {
        return jedisTemplate.execute(jedis -> {
            return jedis.sadd(key, val);
        });
    }

    public static Long setAdd(JedisTemplate jedisTemplate, final String key, final String... vals) {
        return jedisTemplate.execute(jedis -> {
            return jedis.sadd(key, vals);
        });
    }

    public static List setCounts(JedisTemplate jedisTemplate, final List<String> keys) {
        return jedisTemplate.execute(jedis -> {
            Pipeline p = jedis.pipelined();
            List<Response<Long>> resp = Lists.newArrayListWithCapacity(keys.size());

            for (Object key : keys) {
                resp.add(p.scard((byte[]) key));
            }
            p.sync();
            return Lists.transform(resp, Response::get);
        });
    }
}
