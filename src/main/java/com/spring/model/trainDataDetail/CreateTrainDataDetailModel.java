package com.spring.model.trainDataDetail;

import lombok.Data;

import java.util.Date;


@Data
public class CreateTrainDataDetailModel {

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

    private Integer finishStatus;

    /** 数据来源 */
    private Integer source;

    /** 医生id（为大项目集成预留） */
    private String doctorId;

    /** 医生姓名（为大项目集成预留） */
    private String doctorName;
}
