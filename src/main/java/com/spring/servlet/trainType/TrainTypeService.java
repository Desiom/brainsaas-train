package com.spring.servlet.trainType;

import com.spring.entity.TrainType;
import com.spring.model.trainType.CreateTrainTypeModel;
import com.spring.model.trainType.UpdateTrainTypeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainTypeService {

    /**
     * 保存
     * @param trainTypeModel
     */
    public void save(CreateTrainTypeModel trainTypeModel);
//    public void save(trainType trainTypeModel);

    /**
     * 保存携带返回值信息
     * @param trainTypeModel
     */
    public TrainType save_r(CreateTrainTypeModel trainTypeModel);
//    public trainType save_r(trainType trainTypeModel);

    /**
     * 修改
     * @param trainTypeModel
     */
    public void update(UpdateTrainTypeModel trainTypeModel);
//    public void update(trainType trainTypeModel);

    /**
     * 修改携带返回值信息
     * @param trainTypeModel
     */
    public TrainType update_r(UpdateTrainTypeModel trainTypeModel);
//    public trainType update_r(trainType trainTypeModel);


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
    public TrainType get(Integer id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainType> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainType> findPage(String condition, Pageable pageable);


}
