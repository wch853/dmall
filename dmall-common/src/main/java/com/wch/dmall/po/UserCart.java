package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户购物车记录
 */
@Getter
@Setter
public class UserCart {

    /**
     * 用户购物车记录ID
     */
    private int id;


    /**
     * 用户ID
     */
    private int userId;

    /**
     * 产品编号
     */
    private int productId;

    /**
     * 购买产品数量
     */
    private int quantity;

    /**
     * 购物车记录状态：0-删除，1-未删除
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
