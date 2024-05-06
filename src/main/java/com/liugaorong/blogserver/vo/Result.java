package com.liugaorong.blogserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;

    public static Result success(){
        return new Result(0,null,"success");
    }

    public static Result success(Object data){
        return new Result(0,data,"success");
    }

    public static Result error(String msg){
        return new Result(1,null,msg);
    }
}
