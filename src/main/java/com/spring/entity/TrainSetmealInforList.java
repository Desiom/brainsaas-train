package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


/**
 * 套餐游戏关联表
 * 表 train_setmeal_infor_list
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_setmeal_infor_list")
public class TrainSetmealInforList{

    /** 套餐游戏关联表id */
    @Id
    @Column(name = "setmeal_infor_id")
    private String setmealInforId;

    /** 套餐id*/
    @NotBlank(message = "套餐id不能为空")
    @Column(name = "setmeal_id")
    private String setmealId;

    /** 套餐名称方便回显*/
    @Column(name = "setmeal_name")
    private String setmealName;

    /** 游戏id */
    @NotBlank(message = "游戏id不能为空")
    @Column(name = "train_id")
    private Integer trainId;

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

    /**
     * 1对1关联示例
     */
//    @OneToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name="scale_id")
//    private TrainInfo scaleInfor;
//    @Column(name = "scale_id")
//    private Integer scaleId;
}