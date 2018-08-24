package com.spring.exception;

import com.spring.enums.ResultEnum;
import lombok.Data;

/**
 * Created by Desiom on 2018/6/6.
 */
//springboot框架中只会对RuntimeException的异常进行事务回滚，exception则不会，RuntimeException继承exception
@Data
public class ResultException extends RuntimeException{
    private Integer code;

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    //使用枚举的方式
    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());//将message信息传递给父类RuntimeException
        this.code = resultEnum.getCode();
    }
}
