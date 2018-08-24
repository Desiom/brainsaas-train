package com.spring.controller;

import com.spring.entity.TrainType;
import com.spring.enums.ResultEnum;
import com.spring.model.trainType.CreateTrainTypeModel;
import com.spring.model.trainType.UpdateTrainTypeModel;
import com.spring.servlet.trainType.TrainTypeService;
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
@RequestMapping(value = "trainType")
public class TrainTypeController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainTypeController.class );

    @Autowired
    private TrainTypeService trainTypeService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainType/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainTypeModel trainTypeModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainType trainTypeModel, BindingResult bindingResult){
            trainTypeService.save(trainTypeModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id, ModelMap modelMap){
        TrainType trainType = trainTypeService.get(id);
        modelMap.put("trainType",trainType);
        return "pages/trainType/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainTypeModel trainTypeModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainType trainTypeModel, BindingResult bindingResult){
            trainTypeService.update(trainTypeModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainTypeService.delete(ids);
        return ResultVOUtil.success();
    }

    /**
     * 根据量表ID获取量表
     * @param id
     * @return
     */
    @RequestMapping("/get/{id}")
    @ResponseBody
    public ResultVO get(@PathVariable("id")Integer id){
        TrainType trainType = trainTypeService.get(id);
        if (trainType == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainType);
    }
}
