package com.spring.servlet.trainSetmealLabel;

import com.spring.entity.TrainSetmealLabel;
import com.spring.model.trainSetmealLabel.CreateTrainSetmealLabelModel;
import com.spring.model.trainSetmealLabel.UpdateTrainSetmealLabelModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainSetmealLabelService {

    /**
     * 保存
     * @param trainSetmealLabelModel
     */
    public void save(CreateTrainSetmealLabelModel trainSetmealLabelModel);
//    public void save(trainSetmealLabel trainSetmealLabelModel);

    /**
     * 保存携带返回值信息
     * @param trainSetmealLabelModel
     */
    public TrainSetmealLabel save_r(CreateTrainSetmealLabelModel trainSetmealLabelModel);
//    public trainSetmealLabel save_r(trainSetmealLabel trainSetmealLabelModel);

    /**
     * 修改
     * @param trainSetmealLabelModel
     */
    public void update(UpdateTrainSetmealLabelModel trainSetmealLabelModel);
//    public void update(trainSetmealLabel trainSetmealLabelModel);

    /**
     * 修改携带返回值信息
     * @param trainSetmealLabelModel
     */
    public TrainSetmealLabel update_r(UpdateTrainSetmealLabelModel trainSetmealLabelModel);
//    public trainSetmealLabel update_r(trainSetmealLabel trainSetmealLabelModel);


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
    public TrainSetmealLabel get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainSetmealLabel> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmealLabel> findPage(String condition, Pageable pageable);


}
