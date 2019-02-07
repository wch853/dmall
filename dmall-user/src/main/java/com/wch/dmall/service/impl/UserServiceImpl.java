package com.wch.dmall.service.impl;

import com.wch.dmall.dao.IUserDao;
import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.dto.UserInfoDto;
import com.wch.dmall.exception.BusinessException;
import com.wch.dmall.po.UserInfo;
import com.wch.dmall.service.IUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public UserInfoDto userLogin(LoginDto loginDto) throws UnsupportedEncodingException {
        UserInfo userInfo = userDao.selectUser(loginDto);
        UserInfoDto userInfoDto;
        if (null != userInfo) {
            String cryptPassword = Md5Crypt.md5Crypt(loginDto.getPassword().getBytes("UTF-8"), userInfo.getSalt());
            if (!userInfo.getPassword().equals(cryptPassword)) {
                throw new BusinessException("密码错误");
            }
            userInfoDto= new UserInfoDto();
            BeanUtils.copyProperties(userInfo, userInfoDto);
        } else {
            throw new BusinessException("此用户不存在");
        }
        return userInfoDto;
    }
}
