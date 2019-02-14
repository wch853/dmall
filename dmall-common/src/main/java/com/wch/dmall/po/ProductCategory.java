package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 产品品类信息
 */
@Getter
@Setter
public class ProductCategory {

    /**
     * 产品品类ID
     */
    private int id;

    /**
     * 产品品类名称
     */
    private String categoryName;

    /**
     * 父品类ID
     */
    private int parentId;

    /**
     * 品类状态：0-禁用，1-启用
     */
    private int status;

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
