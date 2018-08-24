package com.spring.vo.apiObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.entity.TrainDataLog;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class DayHistory {

    /** 日程id */
    @JsonProperty("scheduleId")
    private String scheduleId;

    /** 用户ID */
    @JsonProperty("userId")
    private String userId;

    /** 用户姓名 */
    @JsonProperty("userName")
    private String userName;

    /** 日期信息值（int）（20180101） */
    @JsonProperty("date")
    private String date;

    /** 处方中完成的训练集合 */
    @JsonProperty("trainList")
    private List<SetmealTrainVO> trainList;

    public DayHistory(){

    }

    public DayHistory(String scheduleId, String userId, String userName, Integer date,List<SetmealTrainVO> trainList) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.userName = userName;
        this.date = (date+"").substring(0,4)
                +"-"+(date+"").substring(4,6)
                +"-"+(date+"").substring(6,8);
        this.trainList = trainList;
    }
}
