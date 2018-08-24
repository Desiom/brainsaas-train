package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


/**
 * 套餐难度表
 * 表 train_difficulty
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_difficulty")
public class TrainDifficulty implements Serializable {

//    private static final long serialVersionUID = 1L;

    /** 难度id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "difficulty_id")
    private Integer difficultyId;

    /** 难度名称 */
    @NotBlank(message = "名称不能为空")
    @Column(name = "difficulty_name")
    private String difficultyName;

    /** 难度描述 */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "difficulty_describe")
    private String difficultyDescribe;

    /** 父ID */
    @Column(name = "parent_id")
    private Integer parentId;

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

}
