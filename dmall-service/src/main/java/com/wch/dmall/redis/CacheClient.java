package com.wch.dmall.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
public class CacheClient {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     */
    public void set(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 写入缓存并设置过期时间
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public void setex(Object key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 给key指定一个过期时间
     *
     * @param key
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean expire(Object key, long expireTime, TimeUnit timeUnit) {
        return redisTemplate.boundValueOps(key).expire(expireTime, timeUnit);
    }

    /**
     * 获取指定key的过期时间
     *
     * @param key
     * @return
     */
    public long ttl(Object key) {
        return redisTemplate.boundValueOps(key).getExpire();
    }

    /**
     * 删除缓存
     *
     * @param key
     * @return
     */
    public boolean del(Object key) {
        return redisTemplate.delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param keys
     * @return
     */
    public boolean delBach(Object... keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 写入hash
     *
     * @param key
     * @param field
     * @param value
     */
    public void hmset(Object key, Object field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 批量写入hash
     *
     * @param key
     * @param map
     */
    public void hmsetBatch(Object key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 读取hash
     *
     * @param key
     * @param field
     * @return
     */
    public Object hmget(Object key, Object field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 批量删除hash下的field
     *
     * @param key
     * @param fields
     * @return
     */
    public Long del(Object key, Object... fields) {
        return redisTemplate.opsForHash().delete(key, fields);
    }
}
