package com.spring.servlet.trainSetmeal.impl;

import com.spring.entity.TrainSetmeal;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainSetmeal.CreateTrainSetmealModel;
import com.spring.model.trainSetmeal.UpdateTrainSetmealModel;
import com.spring.repository.TrainSetmealRepository;
import com.spring.servlet.trainSetmeal.TrainSetmealService;
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
public class TrainSetmealImplService implements TrainSetmealService {

    @Autowired
    private TrainSetmealRepository trainSetmealRepository;

    /**
     * 保存
     *
     * @param trainSetmealModel
     */
    @Override
    public void save(CreateTrainSetmealModel trainSetmealModel){
//    public void save(trainSetmeal trainSetmealModel) {
//        trainSetmealRepository.save(trainSetmealModel);
        TrainSetmeal trainSetmeal = new TrainSetmeal();
        UpdateUtil.copyNonNullProperties(trainSetmealModel,trainSetmeal);
        trainSetmealRepository.save(trainSetmeal);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainSetmealModel
     */
    @Override
    public TrainSetmeal save_r(CreateTrainSetmealModel trainSetmealModel){
//    public trainSetmeal save_r(trainSetmeal trainSetmealModel) {
//        return trainSetmealRepository.save(trainSetmealModel);
        TrainSetmeal trainSetmeal = new TrainSetmeal();
        UpdateUtil.copyNonNullProperties(trainSetmealModel,trainSetmeal);
        return trainSetmealRepository.save(trainSetmeal);
    }

    /**
     * 修改
     *
     * @param trainSetmealModel
     */

    @Override
    public void update(UpdateTrainSetmealModel trainSetmealModel){
//    public void update(trainSetmeal trainSetmealModel) {
        Optional<TrainSetmeal> scaleItemOptional = trainSetmealRepository.findById(trainSetmealModel.getSetmealId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainSetmealRepository.save(trainSetmealModel);
        TrainSetmeal trainSetmeal = new TrainSetmeal();
        UpdateUtil.copyNonNullProperties(trainSetmealModel,trainSetmeal);
        trainSetmealRepository.save(trainSetmeal);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainSetmealModel
     */
    @Override
    public TrainSetmeal update_r(UpdateTrainSetmealModel trainSetmealModel){
//    public trainSetmeal update_r(trainSetmeal trainSetmealModel) {
        Optional<TrainSetmeal> scaleItemOptional = trainSetmealRepository.findById(trainSetmealModel.getSetmealId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainSetmealRepository.save(trainSetmealModel);
        TrainSetmeal trainSetmeal = new TrainSetmeal();
        UpdateUtil.copyNonNullProperties(trainSetmealModel,trainSetmeal);
        return trainSetmealRepository.save(trainSetmeal);
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
            trainSetmealRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainSetmeal get(String id) {
        Optional<TrainSetmeal> scaleItemRepositoryOptional = trainSetmealRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainSetmeal> findAll() {
        return trainSetmealRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmeal> findPage(String condition, Pageable pageable) {
        return trainSetmealRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainSetmeal> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainSetmeal> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
