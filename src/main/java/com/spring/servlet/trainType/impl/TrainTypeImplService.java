package com.spring.servlet.trainType.impl;

import com.spring.entity.TrainType;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainType.CreateTrainTypeModel;
import com.spring.model.trainType.UpdateTrainTypeModel;
import com.spring.repository.TrainTypeRepository;
import com.spring.servlet.trainType.TrainTypeService;
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
public class TrainTypeImplService implements TrainTypeService {

    @Autowired
    private TrainTypeRepository trainTypeRepository;

    /**
     * 保存
     *
     * @param trainTypeModel
     */
    @Override
    public void save(CreateTrainTypeModel trainTypeModel){
//    public void save(trainType trainTypeModel) {
//        trainTypeRepository.save(trainTypeModel);
        TrainType trainType = new TrainType();
        UpdateUtil.copyNonNullProperties(trainTypeModel,trainType);
        trainTypeRepository.save(trainType);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainTypeModel
     */
    @Override
    public TrainType save_r(CreateTrainTypeModel trainTypeModel){
//    public trainType save_r(trainType trainTypeModel) {
//        return trainTypeRepository.save(trainTypeModel);
        TrainType trainType = new TrainType();
        UpdateUtil.copyNonNullProperties(trainTypeModel,trainType);
        return trainTypeRepository.save(trainType);
    }

    /**
     * 修改
     *
     * @param trainTypeModel
     */

    @Override
    public void update(UpdateTrainTypeModel trainTypeModel){
//    public void update(trainType trainTypeModel) {
        Optional<TrainType> scaleItemOptional = trainTypeRepository.findById(trainTypeModel.getTypeId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainTypeRepository.save(trainTypeModel);
        TrainType trainType = new TrainType();
        UpdateUtil.copyNonNullProperties(trainTypeModel,trainType);
        trainTypeRepository.save(trainType);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainTypeModel
     */
    @Override
    public TrainType update_r(UpdateTrainTypeModel trainTypeModel){
//    public trainType update_r(trainType trainTypeModel) {
        Optional<TrainType> scaleItemOptional = trainTypeRepository.findById(trainTypeModel.getTypeId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainTypeRepository.save(trainTypeModel);
        TrainType trainType = new TrainType();
        UpdateUtil.copyNonNullProperties(trainTypeModel,trainType);
        return trainTypeRepository.save(trainType);
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
            trainTypeRepository.deleteById(Integer.valueOf(id));
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainType get(Integer id) {
        Optional<TrainType> scaleItemRepositoryOptional = trainTypeRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainType> findAll() {
        return trainTypeRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainType> findPage(String condition, Pageable pageable) {
        return trainTypeRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainType> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainType> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
