package com.spring.controller;

import com.spring.entity.TrainSetmealLabel;
import com.spring.enums.ResultEnum;
import com.spring.model.trainSetmealLabel.CreateTrainSetmealLabelModel;
import com.spring.model.trainSetmealLabel.UpdateTrainSetmealLabelModel;
import com.spring.servlet.trainSetmealLabel.TrainSetmealLabelService;
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
@RequestMapping(value = "trainSetmealLabel")
public class TrainSetmealLabelController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainSetmealLabelController.class );

    @Autowired
    private TrainSetmealLabelService trainSetmealLabelService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainSetmealLabel/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainSetmealLabelModel trainSetmealLabelModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainSetmealLabel trainSetmealLabelModel, BindingResult bindingResult){
            trainSetmealLabelService.save(trainSetmealLabelModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainSetmealLabel trainSetmealLabel = trainSetmealLabelService.get(id);
        modelMap.put("trainSetmealLabel",trainSetmealLabel);
        return "pages/trainSetmealLabel/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainSetmealLabelModel trainSetmealLabelModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainSetmealLabel trainSetmealLabelModel, BindingResult bindingResult){
            trainSetmealLabelService.update(trainSetmealLabelModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainSetmealLabelService.delete(ids);
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
        TrainSetmealLabel trainSetmealLabel = trainSetmealLabelService.get(id);
        if (trainSetmealLabel == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainSetmealLabel);
    }
}
