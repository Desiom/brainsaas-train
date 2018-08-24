package com.spring.model.trainSetmeal;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainSetmealModel extends CreateTrainSetmealModel {

    /** 套餐id */
    @NotNull(message = "不能为空")
    private String setmealId;
}
