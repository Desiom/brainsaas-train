package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


/**
 * 套餐表
 * 表 train_setmeal
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_setmeal")
public class TrainSetmeal {

    /** 套餐id */
    @Id
    @Column(name = "setmeal_id")
    private String setmealId;

    /** 套餐名称 */
    @NotBlank(message = "名称不能为空")
    @Column(name = "setmeal_name")
    private String setmealName;

    /** 私有套餐对应的社区id（公开通用的为0） */
    @Column(name = "setmeal_private")
    private String setmealPrivate;

    /** 套餐描述 */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "setmeal_describe")
    private String setmealDescribe;

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

    /** 训练列表集合 */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "train_setmeal_infor_list",joinColumns = @JoinColumn(name = "setmeal_id",referencedColumnName = "setmeal_id"),inverseJoinColumns = @JoinColumn(name = "train_id",referencedColumnName = "train_id"))
    @OrderBy("sort ASC")
    private List<TrainInfor> trainInforList;

}
