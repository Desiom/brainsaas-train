package com.spring.servlet.trainInfor.impl;

import com.spring.entity.TrainInfor;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainInfor.CreateTrainInforModel;
import com.spring.model.trainInfor.UpdateTrainInforModel;
import com.spring.repository.TrainInforRepository;
import com.spring.servlet.trainInfor.TrainInforService;
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
public class TrainInforImplService implements TrainInforService {

    @Autowired
    private TrainInforRepository trainInforRepository;

    /**
     * 保存
     *
     * @param trainInforModel
     */
    @Override
    public void save(CreateTrainInforModel trainInforModel){
//    public void save(trainInfor trainInforModel) {
//        trainInforRepository.save(trainInforModel);
        TrainInfor trainInfor = new TrainInfor();
        UpdateUtil.copyNonNullProperties(trainInforModel,trainInfor);
        trainInforRepository.save(trainInfor);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainInforModel
     */
    @Override
    public TrainInfor save_r(CreateTrainInforModel trainInforModel){
//    public trainInfor save_r(trainInfor trainInforModel) {
//        return trainInforRepository.save(trainInforModel);
        TrainInfor trainInfor = new TrainInfor();
        UpdateUtil.copyNonNullProperties(trainInforModel,trainInfor);
        return trainInforRepository.save(trainInfor);
    }

    /**
     * 修改
     *
     * @param trainInforModel
     */

    @Override
    public void update(UpdateTrainInforModel trainInforModel){
//    public void update(trainInfor trainInforModel) {
        Optional<TrainInfor> scaleItemOptional = trainInforRepository.findById(trainInforModel.getTrainId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainInforRepository.save(trainInforModel);
        TrainInfor trainInfor = new TrainInfor();
        UpdateUtil.copyNonNullProperties(trainInforModel,trainInfor);
        trainInforRepository.save(trainInfor);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainInforModel
     */
    @Override
    public TrainInfor update_r(UpdateTrainInforModel trainInforModel){
//    public trainInfor update_r(trainInfor trainInforModel) {
        Optional<TrainInfor> scaleItemOptional = trainInforRepository.findById(trainInforModel.getTrainId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainInforRepository.save(trainInforModel);
        TrainInfor trainInfor = new TrainInfor();
        UpdateUtil.copyNonNullProperties(trainInforModel,trainInfor);
        return trainInforRepository.save(trainInfor);
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
            trainInforRepository.deleteById(Integer.valueOf(id));
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainInfor get(Integer id) {
        Optional<TrainInfor> scaleItemRepositoryOptional = trainInforRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainInfor> findAll() {
        return trainInforRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainInfor> findPage(String condition, Pageable pageable) {
        return trainInforRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainInfor> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainInfor> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
