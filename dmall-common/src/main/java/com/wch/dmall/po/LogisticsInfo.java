package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 物流信息
 */
@Getter
@Setter
public class LogisticsInfo {

    /**
     * 物流信息记录ID
     */
    private int id;

    /**
     * 所属用户ID
     */
    private int userId;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人联系电话
     */
    private String receiverPhone;

    /**
     * 所属省份
     */
    private String province;

    /**
     * 所属市级单位
     */
    private String city;

    /**
     * 所属区/县
     */
    private String district;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 物流信息记录状态：0-删除，1-用户默认收货地址，2-用户收货地址
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
