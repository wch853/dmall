package com.wch.dmall.dao.impl;

import com.wch.dmall.dao.IUserDao;
import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.po.UserInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements IUserDao {

    @Resource(name = "userSqlSessionTemplate")
    private SqlSessionTemplate sst;

    @Override
    public UserInfo selectUser(LoginDto loginDto) {
        return sst.selectOne("user.selectUser", loginDto);
    }
}
