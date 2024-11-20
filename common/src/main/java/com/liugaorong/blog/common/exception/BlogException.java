package com.liugaorong.blog.common.exception;

import com.liugaorong.blog.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class BlogException extends RuntimeException {
  
  private Integer code;
  
  public BlogException(Integer code, String message) {
    super(message);
    this.code = code;
  }
  
  
  public BlogException(ResultCodeEnum resultCodeEnum) {
    super(resultCodeEnum.getMessage());
    this.code = resultCodeEnum.getCode();
  }
}
