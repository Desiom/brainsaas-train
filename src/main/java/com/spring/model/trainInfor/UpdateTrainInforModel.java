package com.spring.model.trainInfor;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainInforModel extends CreateTrainInforModel {

    /** 评估量表信息Id */
    @NotNull(message = "不能为空")
    private Integer trainId;
}
