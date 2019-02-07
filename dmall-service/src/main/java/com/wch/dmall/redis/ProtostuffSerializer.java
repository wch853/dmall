package com.wch.dmall.redis;

import com.wch.dmall.utils.ProtostuffUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * 扩展Redis序列化方式，基于protostuff进行序列化/反序列化
 */
public class ProtostuffSerializer implements RedisSerializer<Object> {

    private static class Wrapper {

        /**
         * 有效数据
         */
        Object payload;

        Wrapper(Object payload) {
            this.payload = payload;
        }
    }

    @Override
    public byte[] serialize(Object t) throws SerializationException {
        return ProtostuffUtil.serialize(new Wrapper(t));
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        Wrapper wrapper = ProtostuffUtil.deSerialize(bytes, Wrapper.class);
        return wrapper.payload;
    }
}
