package com.wch.dmall.controller;

import com.wch.dmall.enums.ResponseEnum;
import com.wch.dmall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseVo errorResponse() {
        return ResponseVo.setResponse(ResponseEnum.FAIL);
    }
}
