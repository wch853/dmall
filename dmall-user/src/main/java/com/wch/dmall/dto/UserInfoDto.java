package com.wch.dmall.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息传输对象
 */
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
}
