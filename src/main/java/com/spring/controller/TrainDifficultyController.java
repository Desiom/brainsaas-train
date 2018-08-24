package com.spring.controller;

import com.spring.entity.TrainDifficulty;
import com.spring.enums.ResultEnum;
import com.spring.model.trainDifficulty.CreateTrainDifficultyModel;
import com.spring.model.trainDifficulty.UpdateTrainDifficultyModel;
import com.spring.servlet.trainDifficulty.TrainDifficultyService;
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
@RequestMapping(value = "trainDifficulty")
public class TrainDifficultyController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainDifficultyController.class );

    @Autowired
    private TrainDifficultyService trainDifficultyService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainDifficulty/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainDifficultyModel trainDifficultyModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainDifficulty trainDifficultyModel, BindingResult bindingResult){
            trainDifficultyService.save(trainDifficultyModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id, ModelMap modelMap){
        TrainDifficulty trainDifficulty = trainDifficultyService.get(id);
        modelMap.put("trainDifficulty",trainDifficulty);
        return "pages/trainDifficulty/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainDifficultyModel trainDifficultyModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainDifficulty trainDifficultyModel, BindingResult bindingResult){
            trainDifficultyService.update(trainDifficultyModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainDifficultyService.delete(ids);
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
        TrainDifficulty trainDifficulty = trainDifficultyService.get(id);
        if (trainDifficulty == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainDifficulty);
    }
}
