package com.spring.model.trainSetmealLabel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainSetmealLabelModel extends CreateTrainSetmealLabelModel {

    /** 套餐标签id */
    @NotNull(message = "不能为空")
    private String setmealLabelId;
}
