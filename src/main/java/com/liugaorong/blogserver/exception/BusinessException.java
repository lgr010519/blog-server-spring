package com.liugaorong.blogserver.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
