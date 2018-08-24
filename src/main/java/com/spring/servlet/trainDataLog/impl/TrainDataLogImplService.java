package com.spring.servlet.trainDataLog.impl;

import com.spring.entity.TrainDataLog;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainDataLog.CreateTrainDataLogModel;
import com.spring.model.trainDataLog.UpdateTrainDataLogModel;
import com.spring.repository.TrainDataLogRepository;
import com.spring.servlet.trainDataLog.TrainDataLogService;
import com.spring.util.UpdateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * Created by Desiom on 2018/6/5.
 */
@Service
public class TrainDataLogImplService implements TrainDataLogService {

    @Autowired
    private TrainDataLogRepository trainDataLogRepository;

    /**
     * 保存
     *
     * @param trainDataLogModel
     */
    @Override
    public void save(CreateTrainDataLogModel trainDataLogModel){
//    public void save(trainDataLog trainDataLogModel) {
//        trainDataLogRepository.save(trainDataLogModel);
        TrainDataLog trainDataLog = new TrainDataLog();
        UpdateUtil.copyNonNullProperties(trainDataLogModel,trainDataLog);
        trainDataLogRepository.save(trainDataLog);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainDataLogModel
     */
    @Override
    public TrainDataLog save_r(CreateTrainDataLogModel trainDataLogModel){
//    public void save(trainDataLog trainDataLogModel) {
//        trainDataLogRepository.save(trainDataLogModel);
        TrainDataLog trainDataLog = new TrainDataLog();
        UpdateUtil.copyNonNullProperties(trainDataLogModel,trainDataLog);
        return trainDataLogRepository.save(trainDataLog);
    }

    /**
     * 修改
     *
     * @param trainDataLogModel
     */

    @Override
    public void update(UpdateTrainDataLogModel trainDataLogModel){
//    public void update(trainDataLog trainDataLogModel) {
        Optional<TrainDataLog> scaleItemOptional = trainDataLogRepository.findById(trainDataLogModel.getLogId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDataLogRepository.save(trainDataLogModel);
        TrainDataLog trainDataLog = new TrainDataLog();
        UpdateUtil.copyNonNullProperties(trainDataLogModel,trainDataLog);
        trainDataLogRepository.save(trainDataLog);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainDataLogModel
     */
    @Override
    public TrainDataLog update_r(UpdateTrainDataLogModel trainDataLogModel){
//    public trainDataLog update_r(trainDataLog trainDataLogModel) {
        Optional<TrainDataLog> scaleItemOptional = trainDataLogRepository.findById(trainDataLogModel.getLogId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainDataLogRepository.save(trainDataLogModel);
        TrainDataLog trainDataLog = new TrainDataLog();
        UpdateUtil.copyNonNullProperties(trainDataLogModel,trainDataLog);
        return trainDataLogRepository.save(trainDataLog);
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
            trainDataLogRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainDataLog get(String id) {
        Optional<TrainDataLog> scaleItemRepositoryOptional = trainDataLogRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainDataLog> findAll() {
        return trainDataLogRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataLog> findPage(String condition, Pageable pageable) {
        return trainDataLogRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainDataLog> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainDataLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
