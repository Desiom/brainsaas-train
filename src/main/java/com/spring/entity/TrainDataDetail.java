package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * 游戏数据详情表
 * 表 scale_score_detail
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_data_detail")
public class TrainDataDetail {

    /** 详情ID */
    @Id
    @Column(name = "detail_id")
    private String detailId;

    /** 用户id*/
    @Column(name = "user_id")
    private String userId;

    /** 套餐id */
    @Column(name = "setmeal_id")
    private String setmealId;

    /** 游戏得分 */
    @Column(name = "train_score")
    private Integer trainScore;

    /** 游戏用时（单位毫秒） */
    @Column(name = "train_time")
    private Integer trainTime;

    /** 游戏完成等级 */
    @Column(name = "train_finishlevel")
    private Integer trainFinishlevel;

    /** 游戏记录数据（json字符串） */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "train_data")
    private String trainData;

    /** 游戏名称（方便回显） */
    @Column(name = "train_name")
    private String trainName;

    /** 训练进度 */
    @Column(name = "train_schedule")
    private Double trainSchedule;

    /** 用户名（方便回显，可补充其他需要一同回显的字段）*/
    @Column(name = "user_name")
    private String userName;

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

    /** 游戏的完成状态（0：未完成；1：已完成；2：进行中，新的纪录默认0） */
    @Column(name = "finish_status")
    private Integer finishStatus;

    /** 数据来源 */
    @Column(name = "source")
    private Integer source;

    /** 医生id（为大项目集成预留） */
    @Column(name = "doctor_id")
    private String doctorId;

    /** 医生姓名（为大项目集成预留） */
    @Column(name = "doctor_name")
    private String doctorName;

    //1对1示例
    /** 总表id */
    @Column(name = "master_id")
    private String masterId;
//    @OneToOne(optional=true,fetch=FetchType.EAGER,cascade = CascadeType.ALL) //JPA注释： 一对一 关系
//    @ManyToOne        //JPA注释： 多对一 关系
//    @NotFound(action=NotFoundAction.IGNORE)
//    @JoinColumn(name="master_id")
//    private TrainDataMaster trainDataMaster;

    /** 游戏类型id */
//    @Column(name = "train_id")
//    private Integer trainId;
    @OneToOne(optional=true,fetch=FetchType.EAGER,cascade = CascadeType.ALL) //JPA注释： 一对一 关系
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name="train_id")
    private TrainInfor trainInfor;

//    /** 总表id*/
//    @Column(name = "master_id")
//    private  String masterId;

}
