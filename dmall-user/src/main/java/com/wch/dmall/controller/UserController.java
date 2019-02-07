package com.wch.dmall.controller;

import com.wch.dmall.enums.ResponseEnum;
import com.wch.dmall.dto.LoginDto;
import com.wch.dmall.service.IUserService;
import com.wch.dmall.vo.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理-接口
 */
@RestController("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 用户登录
     * TODO 接入权限
     *
     * @param loginDto
     * @return
     */
    @GetMapping(value = "/login")
    // TODO 入参校验
    // TODO 权限验证
    // TODO token
    public ResponseVo login(LoginDto loginDto) {
        try {
            return ResponseVo.setResponse(ResponseEnum.SUCCESS, userService.userLogin(loginDto));
        } catch (Exception e) {
            return ResponseVo.setResponse(ResponseEnum.FAIL);
        }
    }

}
