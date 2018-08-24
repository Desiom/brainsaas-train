package com.spring.model.trainDataMaster;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainDataMasterModel extends CreateTrainDataMasterModel {

    /** 评估分数总表 */
    @NotNull(message = "不能为空")
    private String masterId;
}
