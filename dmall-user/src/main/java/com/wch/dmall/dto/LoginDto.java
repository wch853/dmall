package com.wch.dmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginDto implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;
}
