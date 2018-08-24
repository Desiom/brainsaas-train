package com.spring.model.trainDateDiagnosis;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainDateDiagnosisModel extends CreateTrainDateDiagnosisModel {

    /** 用户日程表id */
    @NotNull(message = "不能为空")
    private String diagnosisId;
}
