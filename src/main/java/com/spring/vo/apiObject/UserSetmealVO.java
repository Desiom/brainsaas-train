package com.spring.vo.apiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户的处方信息
 *
 * @author Desiom
 * @date 2018-07-19
 */
@Data
public class UserSetmealVO {

    /** 处方记录id */
    @JsonProperty("recordId")
    private String recordId;

    /** 处方id */
    @JsonProperty("prescriptionId")
    private String prescriptionId;

    /** 处方名称 */
    @JsonProperty("prescriptionName")
    private String prescriptionName;

    /** 处方描述 */
    @JsonProperty("prescriptionDescribe")
    private String prescriptionDescribe;

    /** 处方记录的定制时间 */
    @JsonProperty("prescriptionCreateTime")
    private String prescriptionCreateTime;

    /** 处方中完成的训练集合 */
    @JsonProperty("trainList")
    private List<SetmealTrainVO> trainList;

    public UserSetmealVO(){

    }

    public UserSetmealVO(String recordId, String prescriptionId, String prescriptionName, String prescriptionDescribe, String prescriptionCreateTime, List<SetmealTrainVO> trainList) {
        this.recordId = recordId;
        this.prescriptionId = prescriptionId;
        this.prescriptionName = prescriptionName;
        this.prescriptionDescribe = prescriptionDescribe;
        this.prescriptionCreateTime = prescriptionCreateTime;
        this.trainList = trainList;
    }
}