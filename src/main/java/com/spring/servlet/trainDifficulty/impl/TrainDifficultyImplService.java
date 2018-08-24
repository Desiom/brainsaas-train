package com.spring.servlet.trainDifficulty.impl;

import com.spring.entity.TrainDifficulty;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainDifficulty.CreateTrainDifficultyModel;
import com.spring.model.trainDifficulty.UpdateTrainDifficultyModel;
import com.spring.repository.TrainDifficultyRepository;
import com.spring.servlet.trainDifficulty.TrainDifficultyService;
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
public class TrainDifficultyImplService implements TrainDifficultyService {

    @Autowired
    private TrainDifficultyRepository trainDifficultyRepository;

    /**
     * 保存
     *
     * @param trainDifficultyModel
     */
    @Override
    public void save(CreateTrainDifficultyModel trainDifficultyModel){
//    public void save(trainDifficulty trainDifficultyModel) {
//        trainDifficultyRepository.save(trainDifficultyModel);
        TrainDifficulty trainDifficulty = new TrainDifficulty();
        UpdateUtil.copyNonNullProperties(trainDifficultyModel,trainDifficulty);
        trainDifficultyRepository.save(trainDifficulty);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainDifficultyModel
     */
    @Override
    public TrainDifficulty save_r(CreateTrainDifficultyModel trainDifficultyModel){
//    public void save(trainDifficulty trainDifficultyModel) {
//        trainDifficultyRepository.save(trainDifficultyModel);
        TrainDifficulty trainDifficulty = new TrainDifficulty();
        UpdateUtil.copyNonNullProperties(trainDifficultyModel,trainDifficulty);
        return trainDifficultyRepository.save(trainDifficulty);
    }

    /**
     * 修改
     *
     * @param trainDifficultyModel
     */

    @Override
    public void update(UpdateTrainDifficultyModel trainDifficultyModel){
//    public void update(trainDifficulty trainDifficultyModel) {
        Optional<TrainDifficulty> scaleItemOptional = trainDifficultyRepository.findById(trainDifficultyModel.getDifficultyId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDifficultyRepository.save(trainDifficultyModel);
        TrainDifficulty trainDifficulty = new TrainDifficulty();
        UpdateUtil.copyNonNullProperties(trainDifficultyModel,trainDifficulty);
        trainDifficultyRepository.save(trainDifficulty);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainDifficultyModel
     */
    @Override
    public TrainDifficulty update_r(UpdateTrainDifficultyModel trainDifficultyModel){
//    public trainDifficulty update_r(trainDifficulty trainDifficultyModel) {
        Optional<TrainDifficulty> scaleItemOptional = trainDifficultyRepository.findById(trainDifficultyModel.getDifficultyId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainDifficultyRepository.save(trainDifficultyModel);
        TrainDifficulty trainDifficulty = new TrainDifficulty();
        UpdateUtil.copyNonNullProperties(trainDifficultyModel,trainDifficulty);
        return trainDifficultyRepository.save(trainDifficulty);
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
            trainDifficultyRepository.deleteById(Integer.valueOf(id));
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainDifficulty get(Integer id) {
        Optional<TrainDifficulty> scaleItemRepositoryOptional = trainDifficultyRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainDifficulty> findAll() {
        return trainDifficultyRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDifficulty> findPage(String condition, Pageable pageable) {
        return trainDifficultyRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainDifficulty> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainDifficulty> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
