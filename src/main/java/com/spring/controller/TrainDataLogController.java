package com.spring.controller;

import com.spring.entity.TrainDataLog;
import com.spring.enums.ResultEnum;
import com.spring.model.trainDataLog.CreateTrainDataLogModel;
import com.spring.model.trainDataLog.UpdateTrainDataLogModel;
import com.spring.servlet.trainDataLog.TrainDataLogService;
import com.spring.util.ResultVOUtil;
import com.spring.vo.ResultVO;
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

/**
 * Created by Desiom on 2018/8/23.
 */
@RestController
@RequestMapping(value = "trainDataLog")
public class TrainDataLogController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainDataLogController.class );

    @Autowired
    private TrainDataLogService trainDataLogService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainDataLog/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainDataLogModel trainDataLogModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainDataLog trainDataLogModel, BindingResult bindingResult){
            trainDataLogService.save(trainDataLogModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainDataLog trainDataLog = trainDataLogService.get(id);
        modelMap.put("trainDataLog",trainDataLog);
        return "pages/trainDataLog/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainDataLogModel trainDataLogModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainDataLog trainDataLogModel, BindingResult bindingResult){
            trainDataLogService.update(trainDataLogModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainDataLogService.delete(ids);
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
        TrainDataLog trainDataLog = trainDataLogService.get(id);
        if (trainDataLog == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainDataLog);
    }
}
