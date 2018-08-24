package com.spring.servlet.trainSetmealInforList;

import com.spring.entity.TrainSetmealInforList;
import com.spring.model.trainSetmealInforList.CreateTrainSetmealInforListModel;
import com.spring.model.trainSetmealInforList.UpdateTrainSetmealInforListModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainSetmealInforListService {

    /**
     * 保存
     * @param trainSetmealInforListModel
     */
    public void save(CreateTrainSetmealInforListModel trainSetmealInforListModel);
//    public void save(trainSetmealInforList trainSetmealInforListModel);

    /**
     * 保存携带返回值信息
     * @param trainSetmealInforListModel
     */
    public TrainSetmealInforList save_r(CreateTrainSetmealInforListModel trainSetmealInforListModel);
//    public trainSetmealInforList save_r(trainSetmealInforList trainSetmealInforListModel);

    /**
     * 修改
     * @param trainSetmealInforListModel
     */
    public void update(UpdateTrainSetmealInforListModel trainSetmealInforListModel);
//    public void update(trainSetmealInforList trainSetmealInforListModel);

    /**
     * 修改携带返回值信息
     * @param trainSetmealInforListModel
     */
    public TrainSetmealInforList update_r(UpdateTrainSetmealInforListModel trainSetmealInforListModel);
//    public trainSetmealInforList update_r(trainSetmealInforList trainSetmealInforListModel);


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
    public TrainSetmealInforList get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainSetmealInforList> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmealInforList> findPage(String condition, Pageable pageable);


}
