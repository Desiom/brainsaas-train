package com.spring.model.trainDataLog;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainDataLogModel extends CreateTrainDataLogModel {

    /** 训练数据日志ID */
    @NotNull(message = "不能为空")
    private String logId;
}
