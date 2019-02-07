package com.wch.dmall.service.impl;

import com.wch.dmall.SpringTestBaseConfig;
import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.exception.BusinessException;
import com.wch.dmall.service.IUserService;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

public class UserServiceImplTest extends SpringTestBaseConfig {

    @Resource
    private IUserService userService;

    @Test(expectedExceptions = BusinessException.class, expectedExceptionsMessageRegExp = "此用户不存在")
    public void testUserLogin() throws UnsupportedEncodingException {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("wch");
        loginDto.setPassword(Base64.encodeBase64String("wch".getBytes("UTF-8")));
        userService.userLogin(loginDto);
    }
}