package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息
 */
@Getter
@Setter
public class PayInfo {

    /**
     * 支付记录ID
     */
    private int id;

    /**
     * 所属用户ID
     */
    private int userId;

    /**
     * 所属订单流水号
     */
    private long orderNo;

    /**
     * 支付方式：1-支付宝，2-微信
     */
    private int payWay;

    /**
     * 支付金额
     */
    private BigDecimal payment;

    /**
     * 支付状态：0-未支付，1-已支付
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
