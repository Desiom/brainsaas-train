package com.spring.model.trainSetmealInforList;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainSetmealInforListModel extends CreateTrainSetmealInforListModel {

    /** 套餐游戏关联表id */
    @NotNull(message = "不能为空")
    private String setmealInforId;
}
