package com.spring.controller;

import com.spring.entity.TrainDataDetail;
import com.spring.enums.ResultEnum;
import com.spring.model.trainDataDetail.CreateTrainDataDetailModel;
import com.spring.model.trainDataDetail.UpdateTrainDataDetailModel;
import com.spring.servlet.trainDataDetail.TrainDataDetailService;
import com.spring.util.ResultVOUtil;
import com.spring.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Desiom on 2018/8/23.
 */
@RestController
@RequestMapping(value = "trainDataDetail")
public class TrainDataDetailController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainDataDetailController.class );

    @Autowired
    private TrainDataDetailService trainDataDetailService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainDataDetail/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainDataDetailModel trainDataDetailModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainDataDetail trainDataDetailModel, BindingResult bindingResult){
            trainDataDetailService.save(trainDataDetailModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainDataDetail trainDataDetail = trainDataDetailService.get(id);
        modelMap.put("trainDataDetail",trainDataDetail);
        return "pages/trainDataDetail/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainDataDetailModel trainDataDetailModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainDataDetail trainDataDetailModel, BindingResult bindingResult){
            trainDataDetailService.update(trainDataDetailModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainDataDetailService.delete(ids);
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
        TrainDataDetail trainDataDetail = trainDataDetailService.get(id);
        if (trainDataDetail == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainDataDetail);
    }
}
