package com.spring.servlet.trainDataLog;

import com.spring.entity.TrainDataLog;
import com.spring.model.trainDataLog.CreateTrainDataLogModel;
import com.spring.model.trainDataLog.UpdateTrainDataLogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainDataLogService {

    /**
     * 保存
     * @param trainDataLogModel
     */
    public void save(CreateTrainDataLogModel trainDataLogModel);
//    public void save(trainDataLog trainDataLogModel);

    /**
     * 保存携带返回值信息
     * @param trainDataLogModel
     */
    public TrainDataLog save_r(CreateTrainDataLogModel trainDataLogModel);
//    public trainDataLog save_r(trainDataLog trainDataLogModel);

    /**
     * 修改
     * @param trainDataLogModel
     */
    public void update(UpdateTrainDataLogModel trainDataLogModel);
//    public void update(trainDataLog trainDataLogModel);

    /**
     * 修改携带返回值信息
     * @param trainDataLogModel
     */
    public TrainDataLog update_r(UpdateTrainDataLogModel trainDataLogModel);
//    public trainDataLog update_r(trainDataLog trainDataLogModel);


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
    public TrainDataLog get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainDataLog> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataLog> findPage(String condition, Pageable pageable);


}
