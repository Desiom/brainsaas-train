package com.spring.servlet.trainDataDetail;

import com.spring.entity.TrainDataDetail;
import com.spring.model.trainDataDetail.CreateTrainDataDetailModel;
import com.spring.model.trainDataDetail.UpdateTrainDataDetailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainDataDetailService {

    /**
     * 保存
     * @param trainDataDetailModel
     */
    public void save(CreateTrainDataDetailModel trainDataDetailModel);
//    public void save(trainDataDetail trainDataDetailModel);

    /**
     * 保存携带返回值信息
     * @param trainDataDetailModel
     */
    public TrainDataDetail save_r(CreateTrainDataDetailModel trainDataDetailModel);
//    public trainDataDetail save_r(trainDataDetail trainDataDetailModel);

    /**
     * 修改
     * @param trainDataDetailModel
     */
    public void update(UpdateTrainDataDetailModel trainDataDetailModel);
//    public void update(trainDataDetail trainDataDetailModel);

    /**
     * 修改携带返回值信息
     * @param trainDataDetailModel
     */
    public TrainDataDetail update_r(UpdateTrainDataDetailModel trainDataDetailModel);
//    public trainDataDetail update_r(trainDataDetail trainDataDetailModel);


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
    public TrainDataDetail get(String id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainDataDetail> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataDetail> findPage(String condition, Pageable pageable);


    List<TrainDataDetail> getByMasters(List<String> masterIds);
}
