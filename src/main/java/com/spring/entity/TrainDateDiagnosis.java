package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "train_date_diagnosis")
public class TrainDateDiagnosis {

    /** 用户日程表id */
    @Id
    @Column(name = "diagnosis_id")
    private String diagnosisId;

    /** 用户ID */
    @Column(name = "user_id")
    private String userId;

    /** 用户姓名 */
    @Column(name = "user_name")
    private String userName;

    /** 日期信息值（int）（20180101） */
    @Column(name = "date")
    private Integer date;

    /** 排序字段 */
    @Column(name = "sort")
    private Integer sort;

    /** 0--禁用 1--启用 */
    @Column(name = "status")
    private Integer status;

    /** 备注 */
    @Column(name = "remark")
    private String Remark;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser;

    /** 创建时间 */
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    /** 修改时间 */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

    /** 0--正常 1--删除 */
    @Column(name = "delflag")
    private Integer delFlag;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "diagnosis_id")
    @OrderBy("createTime DESC")
    Set<TrainDataLog> trainDataLogs;
}
