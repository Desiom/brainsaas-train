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
@ConfigurationProperties(prefix = "train-data-master")
public class TrainDataMasterProperties {

    /** 评估分数总表 */
    private String masterId;

    /** 社区id（为患者设置套餐的对象） */
    private String communityId;

    /** 用户ID */
    private String userId;

    /** 套餐id */
    private String setmealId;

    /** 套餐中包含的游戏总数 */
    private Integer itemTotal;

    /** 套餐中已经完成的游戏数目 */
    private Integer itemFinish;

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
