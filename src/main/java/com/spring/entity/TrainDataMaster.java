package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 套餐总记录表
 * 表 scale_score_master
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_data_master")
public class TrainDataMaster {

    /** 评估分数总表 */
    @Id
    @Column(name = "master_id")
    private String masterId;

    /** 社区id（为患者设置套餐的对象） */
    @Column(name = "community_id")
    private String communityId;

    /** 用户ID */
    @Column(name = "user_id")
    private String userId;

    /** 套餐中包含的游戏总数 */
    @Column(name = "item_total")
    private Integer itemTotal;

    /** 套餐中已经完成的游戏数目 */
    @Column(name = "item_finish")
    private Integer itemFinish;

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
    private String doctoName;

    /** 套餐id */
    @Column(name = "setmeal_id")
    private String setmealId;
//    @OneToOne(optional=true,fetch=FetchType.LAZY,cascade = CascadeType.ALL)
//    @NotFound(action=NotFoundAction.IGNORE)
//    @JoinColumn(name="setmeal_id")
//    private TrainSetmeal trainSetmeal;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name = "master_id")
    @OrderBy("createTime DESC")
    Set<TrainDataDetail> trainDataDetails;
}
