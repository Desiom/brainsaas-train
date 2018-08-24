package com.spring.enums;

/**
 * Created by Desiom on 2018/6/6.
 * 枚举文件
 * 统一管理code和message
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    GET_ERROR(1, "获取失败"),
    GET_NOTDATA(1, "没有数据"),
    SAVE_ERROR(1,"保存失败"),
    UPDATE_ERROR(1,"更新失败"),
    SUCCESS(0,"成功"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    //枚举文件通常使用它的构造方法来进行创建，所以不需要set方法

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
