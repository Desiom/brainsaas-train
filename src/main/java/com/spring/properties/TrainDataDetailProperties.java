package com.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Created by Desiom on 2018/8/22.
 */
@Data
//注入配置必备注解
@Component
@ConfigurationProperties(prefix = "train-data-detail")
public class TrainDataDetailProperties {

    /** 详情ID */
    private String detailId;

    /** 总表id */
    private String masterId;

    /** 用户id*/
    private String userId;

    /** 套餐id */
    private String setmealId;

    /** 游戏类型id */
    private Integer trainId;

    /** 游戏得分 */
    private Integer trainScore;

    /** 游戏用时（单位毫秒） */
    private Integer trainTime;

    /** 游戏完成等级 */
    private Integer trainFinishlevel;

    /** 游戏记录数据（json字符串） */
    private String trainData;

    /** 游戏名称（方便回显） */
    private String trainName;

    /** 用户名（方便回显，可补充其他需要一同回显的字段）*/
    private String userName;

    /** 排序字段 */
    private Integer sort;

    /** 0--禁用 1--启用 */
    private Integer status;

    /** 备注 */
    private String Remark;

    /** 创建人 */
    private String createUser;

    /** 创建时间 */
    private Date createTime;

    /** 修改时间 */
    private Date updateTime;

    /** 0--正常 1--删除 */
    private Integer delFlag;

    /** 游戏的完成状态（0：未完成；1：已完成；2：进行中，新的纪录默认0） */
    private Integer finishStatus;

    /** 数据来源 */
    private Integer source;

    /** 医生id（为大项目集成预留） */
    private String doctorId;

    /** 医生姓名（为大项目集成预留） */
    private String doctorName;
}
