package com.spring.model.trainDataDetail;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainDataDetailModel extends CreateTrainDataDetailModel {

    /** 详情ID */
    @NotNull(message = "不能为空")
    private String detailId;
}
