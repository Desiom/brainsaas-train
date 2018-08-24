package com.spring.handle;

/**
 * Created by Desiom on 2018/6/6.
 */

import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.util.ResultVOUtil;
import com.spring.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    //打印日志，记录未知异常
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e){
        //判断是否是自己定义的ResultException
        if(e instanceof ResultException){
            ResultException resultException = (ResultException) e;
            return ResultVOUtil.oerror(resultException.getCode(),resultException.getMessage());
        }else{//系统异常
            logger.error("【系统异常】{}",e);
            return ResultVOUtil.error(ResultEnum.UNKONW_ERROR);
        }
    }
}
