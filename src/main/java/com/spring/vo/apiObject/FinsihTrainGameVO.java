package com.spring.vo.apiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 随访、诊断、报告，Android来源数据
 *
 * @author Desiom
 * @date 2018-07-19
 */
@Data
public class FinsihTrainGameVO {

        /** 训练id */
    @JsonProperty("trainId")
    private Integer trainId;

        /** 训练名称 */
    @JsonProperty("trainName")
    private String trainName;

        /** 训练缩略图 */
    @JsonProperty("trainIcon")
    private String trainIcon;

    public FinsihTrainGameVO(){

    }
}