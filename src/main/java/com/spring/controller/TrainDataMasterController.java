package com.spring.controller;

import com.spring.entity.TrainDataDetail;
import com.spring.entity.TrainDataMaster;
import com.spring.entity.TrainSetmeal;
import com.spring.enums.ResultEnum;
import com.spring.model.trainDataMaster.CreateTrainDataMasterModel;
import com.spring.model.trainDataMaster.UpdateTrainDataMasterModel;
import com.spring.servlet.trainDataDetail.TrainDataDetailService;
import com.spring.servlet.trainDataMaster.TrainDataMasterService;
import com.spring.servlet.trainSetmeal.TrainSetmealService;
import com.spring.util.ResultVOUtil;
import com.spring.vo.ResultVO;
import com.spring.vo.apiObject.FinsihTrainSetmealVO;
import com.spring.vo.apiObject.SetmealTrainVO;
import com.spring.vo.apiObject.UserSetmealVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Desiom on 2018/8/23.
 */
@RestController
@RequestMapping(value = "trainDataMaster")
public class TrainDataMasterController {

    //使用log打印
    private final static Logger logger = LoggerFactory.getLogger(TrainDataMasterController.class );

    @Autowired
    private TrainDataMasterService trainDataMasterService;

    @Autowired
    private TrainDataDetailService trainDataDetailService;

    @Autowired
    private TrainSetmealService trainSetmealService;

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/trainDataMaster/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Validated CreateTrainDataMasterModel trainDataMasterModel, BindingResult bindingResult){
//    public ResultVO create(@Validated trainDataMaster trainDataMasterModel, BindingResult bindingResult){
            trainDataMasterService.save(trainDataMasterModel);
        return ResultVOUtil.success();
    }


    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        TrainDataMaster trainDataMaster = trainDataMasterService.get(id);
        modelMap.put("trainDataMaster",trainDataMaster);
        return "pages/trainDataMaster/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultVO update(@Validated UpdateTrainDataMasterModel trainDataMasterModel, BindingResult bindingResult){
//    public ResultVO update(@Validated trainDataMaster trainDataMasterModel, BindingResult bindingResult){
            trainDataMasterService.update(trainDataMasterModel);
        return ResultVOUtil.success();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public ResultVO delete(@PathVariable("ids")String ids){
        trainDataMasterService.delete(ids);
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
        TrainDataMaster trainDataMaster = trainDataMasterService.get(id);
        if (trainDataMaster == null) {
            return ResultVOUtil.error(ResultEnum.GET_ERROR);
        }
        return ResultVOUtil.success(trainDataMaster);
    }

    /**
     * 根据患者ID获取用户最新处方下的所有训练
     * @param userId
     * @return
     */
    @RequestMapping("/getByUser/{userId}")
    @ResponseBody
    public ResultVO getByUser(@PathVariable("userId")String userId){
        //用户不存在处方
        TrainDataMaster trainDataMaster = trainDataMasterService.getNewByUserId(userId);
        if (trainDataMaster == null) {
            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
        }
        //用户的处方不存在
        TrainSetmeal trainSetmeal = trainSetmealService.get(trainDataMaster.getSetmealId());
        if (trainSetmeal == null) {
            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
        }
        Set<TrainDataDetail> trainDataDetails = trainDataMaster.getTrainDataDetails();
        List<SetmealTrainVO> setmealTrainVOS = new ArrayList<>();
        for(TrainDataDetail trainDataDetail:trainDataDetails){
            SetmealTrainVO setmealTrainVO = new SetmealTrainVO(trainDataDetail.getTrainInfor().getTrainId(),
                    trainDataDetail.getTrainName(),
                    trainDataDetail.getTrainInfor().getTrainIcon(),
                    trainDataDetail.getTrainScore()+"",
                    trainDataDetail.getTrainTime(),
                    trainDataDetail.getFinishStatus(),
                    trainDataDetail.getTrainFinishlevel(),
                    trainDataDetail.getTrainSchedule()+"");
            setmealTrainVOS.add(setmealTrainVO);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserSetmealVO userSetmealVO = new UserSetmealVO(trainDataMaster.getMasterId(),
                trainSetmeal.getSetmealId(),
                trainSetmeal.getSetmealName(),
                trainSetmeal.getSetmealDescribe(),
                sdf.format(trainDataMaster.getCreateTime()),
                setmealTrainVOS);
        return ResultVOUtil.success(userSetmealVO);
    }

    /**
     * 根据患者ID获取用户最新处方下的所有训练
     * @param userId
     * @return
     */
//    @RequestMapping("/getFinishByUser/{userId}")
//    public ResultVO getFinishByUser(@PathVariable("userId")String userId){
    @RequestMapping("/getFinishByUser")
    @ResponseBody
    public ResultVO getFinishByUser(@RequestParam("userId")String userId){
//        List<TrainDataMaster> trainDataMasterList = trainDataMasterService.getAllFinishByUserId(userId);
//        if (trainDataMasterList == null) {
//            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
//        }
        //用户不存在处方
        TrainDataMaster trainDataMaster = trainDataMasterService.getNewByUserId(userId);
        if (trainDataMaster == null) {
            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
        }
        //用户的处方不存在
        TrainSetmeal trainSetmeal = trainSetmealService.get(trainDataMaster.getSetmealId());
        if (trainSetmeal == null) {
            return ResultVOUtil.error(ResultEnum.GET_NOTDATA);
        }
        Set<TrainDataDetail> trainDataDetails = trainDataMaster.getTrainDataDetails();
        List<SetmealTrainVO> setmealTrainVOS = new ArrayList<>();
        for(TrainDataDetail trainDataDetail:trainDataDetails){
            SetmealTrainVO setmealTrainVO = new SetmealTrainVO(trainDataDetail.getTrainInfor().getTrainId(),
                    trainDataDetail.getTrainName(),
                    trainDataDetail.getTrainInfor().getTrainIcon(),
                    trainDataDetail.getTrainScore()+"",
                    trainDataDetail.getTrainTime(),
                    trainDataDetail.getFinishStatus(),
                    trainDataDetail.getTrainFinishlevel(),
                    trainDataDetail.getTrainSchedule()+"");
            setmealTrainVOS.add(setmealTrainVO);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserSetmealVO userSetmealVO = new UserSetmealVO(trainDataMaster.getMasterId(),
                trainSetmeal.getSetmealId(),
                trainSetmeal.getSetmealName(),
                trainSetmeal.getSetmealDescribe(),
                sdf.format(trainDataMaster.getCreateTime()),
                setmealTrainVOS);
        return ResultVOUtil.success(userSetmealVO);
    }
}
