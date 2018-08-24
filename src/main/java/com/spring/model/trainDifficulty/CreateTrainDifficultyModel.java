package com.spring.model.trainDifficulty;

import lombok.Data;

import java.util.Date;


@Data
public class CreateTrainDifficultyModel {

    /** 难度名称 */
    private String difficultyName;

    /** 难度描述 */
    private String difficultyDescribe;

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
    private Integer delFlag ;

}
