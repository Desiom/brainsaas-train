package com.spring.servlet.trainSetmeal;

import com.spring.entity.TrainSetmeal;
import com.spring.model.trainSetmeal.CreateTrainSetmealModel;
import com.spring.model.trainSetmeal.UpdateTrainSetmealModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainSetmealService {

    /**
     * 保存
     * @param trainSetmealModel
     */
    public void save(CreateTrainSetmealModel trainSetmealModel);
//    public void save(trainSetmeal trainSetmealModel);

    /**
     * 保存携带返回值信息
     * @param trainSetmealModel
     */
    public TrainSetmeal save_r(CreateTrainSetmealModel trainSetmealModel);
//    public trainSetmeal save_r(trainSetmeal trainSetmealModel);

    /**
     * 修改
     * @param trainSetmealModel
     */
    public void update(UpdateTrainSetmealModel trainSetmealModel);
//    public void update(trainSetmeal trainSetmealModel);

    /**
     * 修改携带返回值信息
     * @param trainSetmealModel
     */
    public TrainSetmeal update_r(UpdateTrainSetmealModel trainSetmealModel);
//    public trainSetmeal update_r(trainSetmeal trainSetmealModel);


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
    public TrainSetmeal get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainSetmeal> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmeal> findPage(String condition, Pageable pageable);


}
