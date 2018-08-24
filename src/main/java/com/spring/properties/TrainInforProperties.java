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
@ConfigurationProperties(prefix = "train-infor")
public class TrainInforProperties {

    /** 评估量表信息Id */
    private Integer trainId;

    /** 评估量表名称*/
    private  String trainName;

    /** 游戏类型id */
    private Integer typeId;

    /** 游戏难度性质id */
    private Integer difficultyId;

    /** 游戏描述 */
    private String trainDescribe;

    /** 本游戏最大等级 */
    private Integer trainHlevel;

    /** 本游戏最高得分 */
    private Integer trainFullmarks;

    /** 游戏缩略图 */
    private String trainIcon;

    /** 游戏压缩包线上路径 */
    private String trainPath;

    /** 游戏版本号 */
    private Integer trainVersion;

    /** 游戏总时长 */
    private Integer trainAlltime;

    /** 游戏访问次数 */
    private Integer trainVisits;

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
}