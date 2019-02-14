package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单构成详情
 */
@Getter
@Setter
public class OrderItem {

    /**
     * 订单构成详情记录ID
     */
    private int id;

    /**
     * 所属订单流水号
     */
    private long orderNo;

    /**
     * 产品编号
     */
    private int productId;

    /**
     * 订单项产品购买数量
     */
    private int quantity;

    /**
     * 下单时产品单价
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
