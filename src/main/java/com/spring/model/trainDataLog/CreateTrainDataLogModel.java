package com.spring.model.trainDataLog;

import com.spring.entity.TrainInfor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
public class CreateTrainDataLogModel {

    /** 日程表id */
    private String diagnosisId;

    /** 用户id(方便直接查询参数) */
    private String userId;

    /** 训练日终得分 */
    private Integer trainScore;

    /** 当日该训练总用时（单位毫秒） */
    private Integer trainTime;

    /** 当日该训练最终完成等级 */
    private Integer trainFinishlevel;

    /** 训练记录数据（json字符串） */
    private String trainData;

    /** 训练名称（方便回显） */
    private String trainName;

    /** 训练进度 */
    private Double trainSchedule;

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

    /** 训练的完成状态（0：未完成；1：已完成；2：进行中，新的纪录默认0） */
    private Integer finishStatus;

    /** 数据来源 */
    private Integer source;

    /** 用户名（方便回显，可补充其他需要一同回显的字段）*/
    private String userName;

    /** 医生id（为大项目集成预留） */
    private String doctorId;

    /** 医生姓名（为大项目集成预留） */
    private String doctorName;

    /** 总表id */
    private String masterId;

    /** 游戏类型id */
    private Integer trainId;

}
