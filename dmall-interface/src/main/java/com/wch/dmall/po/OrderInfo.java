package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息
 */
@Getter
@Setter
public class OrderInfo {

    /**
     * 订单信息记录ID
     */
    private int id;

    /**
     * 订单流水号
     */
    private long orderNo;

    /**
     * 所属用户ID
     */
    private int userId;

    /**
     * 订单总金额
     */
    private BigDecimal orderPayment;

    /**
     * 促销优惠价格
     */
    private BigDecimal reduction;

    /**
     * 用户收货地址信息记录ID
     */
    private long logisticsId;

    /**
     * 订单状态：0-已取消，1-未付款，2-已付款，3-已发货，4-已收货，5-交易完成，6-已退货，7-交易关闭
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
