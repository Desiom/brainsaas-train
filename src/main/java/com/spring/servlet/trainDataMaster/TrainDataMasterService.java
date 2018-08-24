package com.spring.servlet.trainDataMaster;

import com.spring.entity.TrainDataMaster;
import com.spring.model.trainDataMaster.CreateTrainDataMasterModel;
import com.spring.model.trainDataMaster.UpdateTrainDataMasterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainDataMasterService {

    /**
     * 保存
     * @param trainDataMasterModel
     */
    public void save(CreateTrainDataMasterModel trainDataMasterModel);
//    public void save(trainDataMaster trainDataMasterModel);

    /**
     * 保存携带返回值信息
     * @param trainDataMasterModel
     */
    public TrainDataMaster save_r(CreateTrainDataMasterModel trainDataMasterModel);
//    public trainDataMaster save_r(trainDataMaster trainDataMasterModel);

    /**
     * 修改
     * @param trainDataMasterModel
     */
    public void update(UpdateTrainDataMasterModel trainDataMasterModel);
//    public void update(trainDataMaster trainDataMasterModel);

    /**
     * 修改携带返回值信息
     * @param trainDataMasterModel
     */
    public TrainDataMaster update_r(UpdateTrainDataMasterModel trainDataMasterModel);
//    public trainDataMaster update_r(trainDataMaster trainDataMasterModel);


    /**
     * 删除
     * @param ids
     */
    public void delete(String ids);

    /**
     * 获取（根据ID）
     * @param id
     * @return
     */
    public TrainDataMaster get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainDataMaster> findAll();


    /**
     * 通过用户id获取最新的处方记录
     * @return
     */
    public TrainDataMaster getNewByUserId(String userId);


    /**
     * 通过用户id获取最新的处方记录
     * @return
     */
    public List<TrainDataMaster> getAllFinishByUserId(String userId);

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataMaster> findPage(String condition, Pageable pageable);


}
