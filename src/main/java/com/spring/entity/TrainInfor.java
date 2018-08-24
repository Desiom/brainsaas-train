package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;

/**
 * 游戏表
 * 表 train_infor
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_infor")
public class TrainInfor implements Serializable {

//    private static final long serialVersionUID = 1L;

    /** 游戏Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Integer trainId;

    /** 游戏名称*/
    @NotBlank(message = "名称不能为空")
    @Column(name = "train_name")
    private  String trainName;

    /** 游戏类型id */
    @Column(name = "type_id")
    private Integer typeId;

    /** 游戏难度性质id */
    @Column(name = "difficulty_id")
    private Integer difficultyId;

    /** 游戏描述 */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "train_describe")
    private String trainDescribe;

    /** 本游戏最大等级 */
    @Column(name = "train_hlevel")
    private Integer trainHlevel;

    /** 本游戏最高得分 */
    @Column(name = "train_fullmarks")
    private Integer trainFullmarks;

    /** 游戏缩略图 */
    @Column(name = "train_icon")
    private String trainIcon;

    /** 游戏压缩包线上路径 */
    @Column(name = "train_path")
    private String trainPath;

    /** 游戏版本号 */
    @Column(name = "train_version")
    private Integer trainVersion;

    /** 游戏总时长 */
    @Column(name = "train_alltime")
    private Integer trainAlltime;

    /** 游戏访问次数 */
    @Column(name = "train_visits")
    private Integer trainVisits;

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