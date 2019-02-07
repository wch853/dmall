package com.wch.dmall.redis;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis配置
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    /**
     * 对可读写要求较高的数据，其value序列化成Json格式
     *
     * @param redisConnectionFactory
     * @return
     */
    // @Bean
    // public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
    //     RedisTemplate<String, Object> template = new RedisTemplate<>();
    //     template.setKeySerializer(new StringRedisSerializer());
    //     template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
    //     template.setConnectionFactory(redisConnectionFactory);
    //     return template;
    // }

    /**
     * 对可读性要求不高、频繁读写、占用内存高的数据，使用protostuff序列化
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setKeySerializer(new ProtostuffSerializer());
        template.setValueSerializer(new ProtostuffSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
