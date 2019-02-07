package com.wch.dmall.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户信息
 */
@Getter
@Setter
public class UserInfo {

    /**
     * 用户ID
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码MD5
     */
    private String password;

    /**
     * 用户密码盐值
     */
    private String salt;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户联系电话
     */
    private String phone;

    /**
     * 用户默认收货地址信息记录ID
     */
    private long logisticsId;

    /**
     * 用户角色：0-管理员，1-用户
     */
    private int role;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
