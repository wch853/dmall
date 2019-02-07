package com.wch.dmall.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Protostuff 序列化/反序列化工具
 */
public class ProtostuffUtil {

    private static Map<Class<?>, Schema<?>> cacheSchema = new ConcurrentHashMap<>();

    /**
     * 获取Schema
     */
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        Schema<T> schema = (Schema<T>) cacheSchema.get(clazz);
        if (null == schema) {
            schema = RuntimeSchema.getSchema(clazz);
            cacheSchema.put(clazz, schema);
        }
        return schema;
    }

    /**
     * 序列化
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T t) {
        byte[] bytes = null;
        if (t != null) {
            Schema schema = getSchema(t.getClass());
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            try {
                bytes = ProtostuffIOUtil.toByteArray(t, schema, buffer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                buffer.clear();
            }
        }
        return bytes;
    }

    /**
     * 反序列化
     */
    public static <T> T deSerialize(byte[] data, Class<T> clazz) {
        T t = null;
        if (data != null && 0 != data.length) {
            try {
                t = getSchema(clazz).newMessage();
                ProtostuffIOUtil.mergeFrom(data, t, getSchema(clazz));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return t;
    }

    /**
     * 序列化List
     */
    public static <T> byte[] serializeList(List<T> list, Class<T> clazz) {
        byte[] result = null;
        if (list != null) {
            ByteArrayOutputStream bos = null;
            Schema<T> schema = getSchema(clazz);
            LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            try {
                bos = new ByteArrayOutputStream();
                ProtostuffIOUtil.writeListTo(bos, list, schema, buffer);
                result = bos.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                buffer.clear();
                try {
                    if (null != bos) {
                        bos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 反序列化List
     */
    public static <T> List<T> deserializeList(byte[] bytes, Class<T> clazz) {
        List<T> result = null;
        if (bytes != null) {
            Schema<T> schema = getSchema(clazz);
            try {
                result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), schema);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
