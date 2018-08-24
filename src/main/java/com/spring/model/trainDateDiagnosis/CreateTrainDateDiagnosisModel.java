package com.spring.model.trainDateDiagnosis;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTrainDateDiagnosisModel {

    /** 用户ID */
    private String userId;

    /** 用户姓名 */
    private String userName;

    /** 日期信息值（int）（20180101） */
    private Integer date;

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
