package com.spring.model.trainType;

import lombok.Data;

import java.util.Date;


@Data
public class CreateTrainTypeModel {

    /** 类型名称 */
    private String typeName;

    /** 类型描述 */
    private String typeDescribe;

    /** 该类型针对的人体能力 */
    private String typePower;

    /** 父ID */
    private Integer parentId;

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
