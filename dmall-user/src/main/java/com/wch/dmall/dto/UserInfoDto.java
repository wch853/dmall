package com.wch.dmall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    /**
     * 用户ID
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户角色
     */
    private String roles;

    /**
     * 用户权限
     */
    private String permissions;

    /**
     * token
     */
    private String token;
}
