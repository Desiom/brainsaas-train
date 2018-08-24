package com.spring.controller;

import com.spring.entity.TrainSetmeal;
import com.spring.enums.ResultEnum;
import com.spring.model.trainSetmeal.CreateTrainSetmealModel;
import com.spring.model.trainSetmeal.UpdateTrainSetmealModel;
import com.spring.servlet.trainSetmeal.TrainSetmealService;
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
@RequestMapping(value = "trainSetmeal")
public class TrainSetmealController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainSetmealController.class );

    @Autowired
    private TrainSetmealService trainSetmealService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainSetmeal/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainSetmealModel trainSetmealModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainSetmeal trainSetmealModel, BindingResult bindingResult){
            trainSetmealService.save(trainSetmealModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainSetmeal trainSetmeal = trainSetmealService.get(id);
        modelMap.put("trainSetmeal",trainSetmeal);
        return "pages/trainSetmeal/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainSetmealModel trainSetmealModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainSetmeal trainSetmealModel, BindingResult bindingResult){
            trainSetmealService.update(trainSetmealModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainSetmealService.delete(ids);
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
        TrainSetmeal trainSetmeal = trainSetmealService.get(id);
        if (trainSetmeal == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainSetmeal);
    }
}
