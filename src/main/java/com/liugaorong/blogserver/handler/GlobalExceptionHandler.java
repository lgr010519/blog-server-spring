package com.liugaorong.blogserver.handler;

import com.liugaorong.blogserver.exception.BusinessException;
import com.liugaorong.blogserver.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Result handlerBusinessException(BusinessException e) {
        e.printStackTrace();
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.error("服务器繁忙！");
    }
}
