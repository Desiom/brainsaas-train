package com.spring.servlet.trainInfor;

import com.spring.entity.TrainInfor;
import com.spring.model.trainInfor.CreateTrainInforModel;
import com.spring.model.trainInfor.UpdateTrainInforModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainInforService {

    /**
     * 保存
     * @param trainInforModel
     */
    public void save(CreateTrainInforModel trainInforModel);
//    public void save(trainInfor trainInforModel);

    /**
     * 保存携带返回值信息
     * @param trainInforModel
     */
    public TrainInfor save_r(CreateTrainInforModel trainInforModel);
//    public trainInfor save_r(trainInfor trainInforModel);

    /**
     * 修改
     * @param trainInforModel
     */
    public void update(UpdateTrainInforModel trainInforModel);
//    public void update(trainInfor trainInforModel);

    /**
     * 修改携带返回值信息
     * @param trainInforModel
     */
    public TrainInfor update_r(UpdateTrainInforModel trainInforModel);
//    public trainInfor update_r(trainInfor trainInforModel);


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
    public TrainInfor get(Integer id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainInfor> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainInfor> findPage(String condition, Pageable pageable);


}
