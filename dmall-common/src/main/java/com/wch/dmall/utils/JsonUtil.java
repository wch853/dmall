package com.wch.dmall.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Json工具类
 * base on jackson
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Object转json字符串
     *
     * @param object object
     * @return String
     */
    public static String toJsonString(Object object) {
        String json;
        if (object instanceof String) {
            json = (String) object;
        } else {
            try {
                json = MAPPER.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return json;
    }

    /**
     * json格式字符串转Bean
     *
     * @param json  json
     * @param clazz Class.Type
     * @param <T>   T
     * @return T
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        T t;
        try {
            t = MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
