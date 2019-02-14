package com.wch.dmall;

import com.wch.dmall.po.OrderInfo;
import com.wch.dmall.po.UserCart;
import com.wch.dmall.redis.ProtostuffSerializer;
import org.testng.annotations.Test;

@Test
public class ProtostuffSerializerTest {

    public void testProtostuffSerializer() {
        ProtostuffSerializer protostuffSerializer = new ProtostuffSerializer();

        UserCart userCart = new UserCart();
        userCart.setId(1);
        byte[] serialize = protostuffSerializer.serialize(userCart);
        UserCart deserialize = (UserCart) protostuffSerializer.deserialize(serialize);
        System.out.println(deserialize.getId());

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1);
        byte[] serialize1 = protostuffSerializer.serialize(orderInfo);
        OrderInfo deserialize1 = (OrderInfo) protostuffSerializer.deserialize(serialize1);
        System.out.println(deserialize1.getId());
    }

}
