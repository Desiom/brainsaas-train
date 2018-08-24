package com.spring.util;


import com.spring.enums.ResultEnum;
import com.spring.vo.ResultVO;

/**
 * 结果处理
 */
public class ResultVOUtil {

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }

    //请求失败,自定义code值与返回信息
    public static ResultVO oerror(Integer code,String message){
        ResultVO result = new ResultVO();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

}
