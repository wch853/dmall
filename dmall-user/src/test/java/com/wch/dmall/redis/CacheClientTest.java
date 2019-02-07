package com.wch.dmall.redis;

import com.wch.dmall.SpringTestBaseConfig;

import javax.annotation.Resource;

public class CacheClientTest extends SpringTestBaseConfig {

    @Resource
    private CacheClient cacheClient;

    public void testCacheClient() {
        cacheClient.setex("name", "wch", 10);
        Object name = cacheClient.get("name");
        System.out.println(name);
    }
}
