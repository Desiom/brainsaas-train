package com.spring.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "train-date-diagnosis")
public class TrainDateDiagnosisProperties {

    /** 日程表id */
    private String diagnosisId;

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
