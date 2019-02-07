package com.wch.dmall.dao;

import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.po.UserInfo;

public interface IUserDao {

    /**
     * 查询用户信息
     *
     * @param loginDto
     * @return
     */
    UserInfo selectUser(LoginDto loginDto);
}
