package com.spring.model.trainSetmeal;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class CreateTrainSetmealModel {

    /** 套餐名称 */
    @NotNull(message = "不能为空")
    private String setmealName;

    /** 私有套餐对应的社区id（公开通用的为0） */
    private String setmealPrivate;

    /** 套餐描述 */
    private String setmealDescribe;

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
