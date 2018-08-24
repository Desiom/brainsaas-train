package com.spring.model.trainDifficulty;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateTrainDifficultyModel extends CreateTrainDifficultyModel {

    /** 难度id */
    @NotNull(message = "不能为空")
    private Integer difficultyId;
}
