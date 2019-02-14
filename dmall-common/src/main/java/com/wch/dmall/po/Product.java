package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品信息
 */
@Getter
@Setter
public class Product {

    /**
     * 产品ID
     */
    private int id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品副标题
     */
    private String subtitle;

    /**
     * 产品详情
     */
    private String detail;

    /**
     * 产品二级品类ID
     */
    private int categoryId;

    /**
     * 产品一级品类ID
     */
    private int categoryParentId;

    /**
     * 产品状态：0-下线，1-在售
     */
    private int status;

    /**
     * 产品单价
     */
    private BigDecimal price;

    /**
     * 库存余位
     */
    private int stockNum;

    /**
     * 产品主图url
     */
    private String mainImg;

    /**
     * 产品副图json
     */
    private String subImg;

    /**
     * 操作用户ID
     */
    private int opId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
