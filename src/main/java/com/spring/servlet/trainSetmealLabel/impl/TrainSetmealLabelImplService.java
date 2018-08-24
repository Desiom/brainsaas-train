package com.spring.servlet.trainSetmealLabel.impl;

import com.spring.entity.TrainSetmealLabel;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainSetmealLabel.CreateTrainSetmealLabelModel;
import com.spring.model.trainSetmealLabel.UpdateTrainSetmealLabelModel;
import com.spring.repository.TrainSetmealLabelRepository;
import com.spring.servlet.trainSetmealLabel.TrainSetmealLabelService;
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
public class TrainSetmealLabelImplService implements TrainSetmealLabelService {

    @Autowired
    private TrainSetmealLabelRepository trainSetmealLabelRepository;

    /**
     * 保存
     *
     * @param trainSetmealLabelModel
     */
    @Override
    public void save(CreateTrainSetmealLabelModel trainSetmealLabelModel){
//    public void save(trainSetmealLabel trainSetmealLabelModel) {
//        trainSetmealLabelRepository.save(trainSetmealLabelModel);
        TrainSetmealLabel trainSetmealLabel = new TrainSetmealLabel();
        UpdateUtil.copyNonNullProperties(trainSetmealLabelModel,trainSetmealLabel);
        trainSetmealLabelRepository.save(trainSetmealLabel);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainSetmealLabelModel
     */
    @Override
    public TrainSetmealLabel save_r(CreateTrainSetmealLabelModel trainSetmealLabelModel){
//    public trainSetmealLabel save_r(trainSetmealLabel trainSetmealLabelModel) {
//        return trainSetmealLabelRepository.save(trainSetmealLabelModel);
        TrainSetmealLabel trainSetmealLabel = new TrainSetmealLabel();
        UpdateUtil.copyNonNullProperties(trainSetmealLabelModel,trainSetmealLabel);
        return trainSetmealLabelRepository.save(trainSetmealLabel);
    }

    /**
     * 修改
     *
     * @param trainSetmealLabelModel
     */

    @Override
    public void update(UpdateTrainSetmealLabelModel trainSetmealLabelModel){
//    public void update(trainSetmealLabel trainSetmealLabelModel) {
        Optional<TrainSetmealLabel> scaleItemOptional = trainSetmealLabelRepository.findById(trainSetmealLabelModel.getSetmealLabelId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainSetmealLabelRepository.save(trainSetmealLabelModel);
        TrainSetmealLabel trainSetmealLabel = new TrainSetmealLabel();
        UpdateUtil.copyNonNullProperties(trainSetmealLabelModel,trainSetmealLabel);
        trainSetmealLabelRepository.save(trainSetmealLabel);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainSetmealLabelModel
     */
    @Override
    public TrainSetmealLabel update_r(UpdateTrainSetmealLabelModel trainSetmealLabelModel){
//    public trainSetmealLabel update_r(trainSetmealLabel trainSetmealLabelModel) {
        Optional<TrainSetmealLabel> scaleItemOptional = trainSetmealLabelRepository.findById(trainSetmealLabelModel.getSetmealLabelId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainSetmealLabelRepository.save(trainSetmealLabelModel);
        TrainSetmealLabel trainSetmealLabel = new TrainSetmealLabel();
        UpdateUtil.copyNonNullProperties(trainSetmealLabelModel,trainSetmealLabel);
        return trainSetmealLabelRepository.save(trainSetmealLabel);
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
            trainSetmealLabelRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainSetmealLabel get(String id) {
        Optional<TrainSetmealLabel> scaleItemRepositoryOptional = trainSetmealLabelRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainSetmealLabel> findAll() {
        return trainSetmealLabelRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmealLabel> findPage(String condition, Pageable pageable) {
        return trainSetmealLabelRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainSetmealLabel> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainSetmealLabel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
