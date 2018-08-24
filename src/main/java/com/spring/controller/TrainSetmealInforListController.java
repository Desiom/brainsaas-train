package com.spring.controller;

import com.spring.entity.TrainSetmealInforList;
import com.spring.enums.ResultEnum;
import com.spring.model.trainSetmealInforList.CreateTrainSetmealInforListModel;
import com.spring.model.trainSetmealInforList.UpdateTrainSetmealInforListModel;
import com.spring.servlet.trainSetmealInforList.TrainSetmealInforListService;
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
@RequestMapping(value = "trainSetmealInforList")
public class TrainSetmealInforListController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainSetmealInforListController.class );

    @Autowired
    private TrainSetmealInforListService trainSetmealInforListService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainSetmealInforList/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainSetmealInforListModel trainSetmealInforListModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainSetmealInforList trainSetmealInforListModel, BindingResult bindingResult){
            trainSetmealInforListService.save(trainSetmealInforListModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainSetmealInforList trainSetmealInforList = trainSetmealInforListService.get(id);
        modelMap.put("trainSetmealInforList",trainSetmealInforList);
        return "pages/trainSetmealInforList/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainSetmealInforListModel trainSetmealInforListModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainSetmealInforList trainSetmealInforListModel, BindingResult bindingResult){
            trainSetmealInforListService.update(trainSetmealInforListModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainSetmealInforListService.delete(ids);
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
        TrainSetmealInforList trainSetmealInforList = trainSetmealInforListService.get(id);
        if (trainSetmealInforList == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainSetmealInforList);
    }
}
