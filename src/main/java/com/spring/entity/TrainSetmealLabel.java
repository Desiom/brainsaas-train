package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


/**
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_setmeal_label")
public class TrainSetmealLabel {

    /** 套餐标签id */
    @Id
    @Column(name = "setmeal_label_id")
    private String setmealLabelId;

    /** 标签信息 */
    @Column(name = "label_message")
    private String labelMessage;

    /** 套餐id */
    @Column(name = "setmeal_id")
    private String setmealId;

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

//    /** 一对多示例 */
//    @ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name = "scale_category_scale_infor_list",joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"),inverseJoinColumns = @JoinColumn(name = "scale_id",referencedColumnName = "scale_id"))
//    @OrderBy("sort ASC")
//    private List<TrainInfo> scaleInforList;

}
