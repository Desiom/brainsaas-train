package com.spring.vo.apiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 随访、诊断、报告，Android来源数据
 *
 * @author Desiom
 * @date 2018-07-19
 */
@Data
public class FinsihTrainSetmealVO {

        /** 处方id */
    @JsonProperty("prescriptionId")
    private Integer prescriptionId;

        /** 处方名称 */
    @JsonProperty("prescriptionName")
    private String prescriptionName;

        /** 处方定制时间 */
    @JsonProperty("prescriptionCreateTime")
    private Date prescriptionCreateTime;

        /** 处方中完成的训练集合 */
    @JsonProperty("gameList")
    private List<FinsihTrainGameVO> gameList;

    public FinsihTrainSetmealVO(){

    }
}