package com.spring.servlet.trainDataMaster.impl;

import com.spring.entity.TrainDataMaster;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainDataMaster.CreateTrainDataMasterModel;
import com.spring.model.trainDataMaster.UpdateTrainDataMasterModel;
import com.spring.repository.TrainDataMasterRepository;
import com.spring.servlet.trainDataMaster.TrainDataMasterService;
import com.spring.util.UpdateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by Desiom on 2018/6/5.
 */
@Service
public class TrainDataMasterImplService implements TrainDataMasterService {

    @Autowired
    private TrainDataMasterRepository trainDataMasterRepository;

    /**
     * 保存
     *
     * @param trainDataMasterModel
     */
    @Override
    public void save(CreateTrainDataMasterModel trainDataMasterModel){
//    public void save(trainDataMaster trainDataMasterModel) {
//        trainDataMasterRepository.save(trainDataMasterModel);
        TrainDataMaster trainDataMaster = new TrainDataMaster();
        UpdateUtil.copyNonNullProperties(trainDataMasterModel,trainDataMaster);
        trainDataMasterRepository.save(trainDataMaster);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainDataMasterModel
     */
    @Override
    public TrainDataMaster save_r(CreateTrainDataMasterModel trainDataMasterModel){
//    public trainDataMaster save_r(trainDataMaster trainDataMasterModel) {
//        return trainDataMasterRepository.save(trainDataMasterModel);
        TrainDataMaster trainDataMaster = new TrainDataMaster();
        UpdateUtil.copyNonNullProperties(trainDataMasterModel,trainDataMaster);
        return trainDataMasterRepository.save(trainDataMaster);
    }

    /**
     * 修改
     *
     * @param trainDataMasterModel
     */

    @Override
    public void update(UpdateTrainDataMasterModel trainDataMasterModel){
//    public void update(trainDataMaster trainDataMasterModel) {
        Optional<TrainDataMaster> scaleItemOptional = trainDataMasterRepository.findById(trainDataMasterModel.getMasterId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDataMasterRepository.save(trainDataMasterModel);
        TrainDataMaster trainDataMaster = new TrainDataMaster();
        UpdateUtil.copyNonNullProperties(trainDataMasterModel,trainDataMaster);
        trainDataMasterRepository.save(trainDataMaster);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainDataMasterModel
     */
    @Override
    public TrainDataMaster update_r(UpdateTrainDataMasterModel trainDataMasterModel){
//    public trainDataMaster update_r(trainDataMaster trainDataMasterModel) {
//    public void update(trainDataMaster trainDataMasterModel) {
        Optional<TrainDataMaster> scaleItemOptional = trainDataMasterRepository.findById(trainDataMasterModel.getMasterId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDataMasterRepository.save(trainDataMasterModel);
        TrainDataMaster trainDataMaster = new TrainDataMaster();
        UpdateUtil.copyNonNullProperties(trainDataMasterModel,trainDataMaster);
        return trainDataMasterRepository.save(trainDataMaster);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            if (StringUtils.isBlank(id)) {
                continue;
            }
            trainDataMasterRepository.deleteById(id);
        }
    }


    /**
     * 通过用户id获取最新的处方记录
     * @return
     */
    @Override
    public TrainDataMaster getNewByUserId(String userId){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<TrainDataMaster> trainDataMasterList = trainDataMasterRepository.findByUserId(userId,sort);
        if(trainDataMasterList==null||trainDataMasterList.size()<1){
            return null;
        }
        return trainDataMasterList.get(0);
    }


    /**
     * 通过用户id获取最新的处方记录
     * @return
     */
    @Override
    public List<TrainDataMaster> getAllFinishByUserId(String userId){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<TrainDataMaster> trainDataMasterList = trainDataMasterRepository.findByUserId(userId,sort);
        if(trainDataMasterList==null||trainDataMasterList.size()<1){
            return null;
        }
        return trainDataMasterList;
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainDataMaster get(String id) {
        Optional<TrainDataMaster> scaleItemRepositoryOptional = trainDataMasterRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainDataMaster> findAll() {
        return trainDataMasterRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataMaster> findPage(String condition, Pageable pageable) {
        return trainDataMasterRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainDataMaster> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainDataMaster> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}

