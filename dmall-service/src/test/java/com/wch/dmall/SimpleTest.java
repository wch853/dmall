package com.wch.dmall;

import com.wch.dmall.po.UserCart;
import com.wch.dmall.redis.ProtostuffSerializer;
import com.wch.dmall.utils.JsonUtil;
import com.wch.dmall.utils.ProtostuffUtil;
import org.testng.annotations.Test;

@Test
public class SimpleTest {

    public void test1() {
        UserCart userCart = new UserCart();
        userCart.setId(1);
        ProtostuffSerializer protostuffSerializer = new ProtostuffSerializer();
        byte[] serialize = protostuffSerializer.serialize(userCart);
        UserCart deserialize = (UserCart) protostuffSerializer.deserialize(serialize);
        System.out.println(deserialize.getId());

        byte[] serialize1 = ProtostuffUtil.serialize(userCart);
        UserCart userCart1 = ProtostuffUtil.deSerialize(serialize1, UserCart.class);
        System.out.println(JsonUtil.toJsonString(userCart1));
    }

}
