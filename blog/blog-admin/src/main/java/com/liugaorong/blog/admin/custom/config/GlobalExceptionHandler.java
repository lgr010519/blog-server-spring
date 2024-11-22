package com.liugaorong.blog.admin.custom.config;

import com.liugaorong.blog.common.exception.BlogException;
import com.liugaorong.blog.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  public Result handle(Exception e) {
    e.printStackTrace();
    return Result.fail();
  }
  
  @ExceptionHandler(BlogException.class)
  public Result handle(BlogException e) {
    String message = e.getMessage();
    Integer code = e.getCode();
    e.printStackTrace();
    return Result.fail(code, message);
  }
}
