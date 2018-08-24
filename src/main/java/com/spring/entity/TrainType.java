package com.spring.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Created by Desiom on 2018/8/22.
 */
@Data
@Entity
@Table(name = "train_type")
public class TrainType implements Serializable {

//    private static final long serialVersionUID = 1L;

    /** 类型id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    /** 类型名称 */
    @NotBlank(message = "名称不能为空")
    @Column(name = "type_name")
    private String typeName;

    /** 类型描述 */
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "type_describe")
    private String typeDescribe;

    /** 该类型针对的人体能力 */
    @Column(name = "type_power")
    private String typePower;

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

//    /** 一对多示例 */
//    @ManyToMany(fetch=FetchType.EAGER)
//    @JoinTable(name = "scale_category_scale_infor_list",joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"),inverseJoinColumns = @JoinColumn(name = "scale_id",referencedColumnName = "scale_id"))
//    @OrderBy("sort ASC")
//    private List<TrainInfo> scaleInforList;

}
