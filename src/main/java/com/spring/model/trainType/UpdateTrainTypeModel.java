package com.spring.model.trainType;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainTypeModel extends CreateTrainTypeModel {

    /** 类型id */
    @NotNull(message = "不能为空")
    private Integer typeId;
}
