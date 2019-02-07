package com.wch.dmall.service;

import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.dto.UserInfoDto;

import java.io.UnsupportedEncodingException;

/**
 * 用户服务
 */
public interface IUserService {

    UserInfoDto userLogin(LoginDto loginDto) throws UnsupportedEncodingException;

}
