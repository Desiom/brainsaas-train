package com.spring.vo.apiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 处方下的训练信息
 *
 * @author Desiom
 * @date 2018-07-19
 */
@Data
public class SetmealTrainVO {

        /** 训练id */
    @JsonProperty("trainId")
    private Integer trainId;

        /** 训练名称 */
    @JsonProperty("trainName")
    private String trainName;

        /** 训练缩略图 */
    @JsonProperty("trainIcon")
    private String trainIcon;

    /** 训练当前分数 */
    @JsonProperty("trainScore")
//    private Integer trainScore;
    private String trainScore;

    /** 训练总用时（单位秒） */
    @JsonProperty("trainAllTime")
    private Integer trainAllTime;

    /** 训练完成状态(0：未完成；1：已完成；2：进行中) */
    @JsonProperty("trainStatus")
    private Integer trainStatus;

        /** 训练完成等级 */
    @JsonProperty("trainLevel")
    private Integer trainLevel;

        /** 训练进度 */
    @JsonProperty("trainSchedule")
    private String trainSchedule;

    public SetmealTrainVO(){

    }

    public SetmealTrainVO(Integer trainId, String trainName, String trainIcon, String trainScore, Integer trainAllTime, Integer trainStatus, Integer trainLevel, String trainSchedule) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainIcon = trainIcon;
        this.trainScore = trainScore;
        this.trainAllTime = trainAllTime;
        this.trainStatus = trainStatus;
        this.trainLevel = trainLevel;
        this.trainSchedule = trainSchedule;
    }
}