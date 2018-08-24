package com.spring.controller;

import com.spring.entity.TrainDataDetail;
import com.spring.entity.TrainDataLog;
import com.spring.entity.TrainDateDiagnosis;
import com.spring.entity.TrainSetmeal;
import com.spring.enums.ResultEnum;
import com.spring.model.trainDateDiagnosis.CreateTrainDateDiagnosisModel;
import com.spring.model.trainDateDiagnosis.UpdateTrainDateDiagnosisModel;
import com.spring.servlet.trainDateDiagnosis.TrainDateDiagnosisService;
import com.spring.util.ResultVOUtil;
import com.spring.vo.ResultVO;
import com.spring.vo.apiObject.DayHistory;
import com.spring.vo.apiObject.SetmealTrainVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Desiom on 2018/8/23.
 */
@RestController
@RequestMapping(value = "trainDateDiagnosis")
public class TrainDateDiagnosisController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainDateDiagnosisController.class );

    @Autowired
    private TrainDateDiagnosisService trainDateDiagnosisService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainDateDiagnosis/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainDateDiagnosisModel trainDateDiagnosisModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainDateDiagnosis trainDateDiagnosisModel, BindingResult bindingResult){
            trainDateDiagnosisService.save(trainDateDiagnosisModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainDateDiagnosis trainDateDiagnosis = trainDateDiagnosisService.get(id);
        modelMap.put("trainDateDiagnosis",trainDateDiagnosis);
        return "pages/trainDateDiagnosis/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainDateDiagnosisModel trainDateDiagnosisModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainDateDiagnosis trainDateDiagnosisModel, BindingResult bindingResult){
            trainDateDiagnosisService.update(trainDateDiagnosisModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainDateDiagnosisService.delete(ids);
        return ResultVOUtil.success();
    }

    /**
     * 根据量表ID获取量表
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    @ResponseBody
    public ResultVO get(@PathVariable("id")String id){
        TrainDateDiagnosis trainDateDiagnosis = trainDateDiagnosisService.get(id);
        if (trainDateDiagnosis == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainDateDiagnosis);
    }

    /**
     * 根据患者ID获取用户最新处方下的所有训练
     * @param userId
     * @return
     */
    @RequestMapping("/getByUser/{userId}")
    @ResponseBody
    public ResultVO getByUser(@PathVariable("userId")String userId){
        //用户不存在往期记录
        List<TrainDateDiagnosis> trainDateDiagnosisList = trainDateDiagnosisService.getDataDiagnosisList(userId);
        if (trainDateDiagnosisList == null) {
            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
        }
        List<DayHistory> histories = new ArrayList<>();
        for(TrainDateDiagnosis trainDateDiagnosis:trainDateDiagnosisList){
            if(trainDateDiagnosis.getTrainDataLogs()==null||trainDateDiagnosis.getTrainDataLogs().size()==0){
                continue;
            }
            List<SetmealTrainVO> setmealTrainVOS = new ArrayList<>();
            for(TrainDataLog trainDataLog:trainDateDiagnosis.getTrainDataLogs()){
                SetmealTrainVO setmealTrainVO = new SetmealTrainVO(trainDataLog.getTrainInfor().getTrainId(),
                        trainDataLog.getTrainName(),
                        trainDataLog.getTrainInfor().getTrainIcon(),
                        trainDataLog.getTrainScore()+"",
                        trainDataLog.getTrainTime(),
                        trainDataLog.getFinishStatus(),
                        trainDataLog.getTrainFinishlevel(),
                        trainDataLog.getTrainSchedule()+"");
                setmealTrainVOS.add(setmealTrainVO);
            }
            DayHistory dayHistory = new DayHistory(
                    trainDateDiagnosis.getDiagnosisId(),
                    trainDateDiagnosis.getUserId(),
                    trainDateDiagnosis.getUserName(),
                    trainDateDiagnosis.getDate(),
                    setmealTrainVOS
            );
            histories.add(dayHistory);
        }
        return ResultVOUtil.success(histories);
    }
}
