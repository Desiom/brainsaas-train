package com.spring.servlet.trainDateDiagnosis.impl;

import com.spring.entity.TrainDateDiagnosis;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainDateDiagnosis.CreateTrainDateDiagnosisModel;
import com.spring.model.trainDateDiagnosis.UpdateTrainDateDiagnosisModel;
import com.spring.repository.TrainDateDiagnosisRepository;
import com.spring.servlet.trainDateDiagnosis.TrainDateDiagnosisService;
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
public class TrainDateDiagnosisImplService implements TrainDateDiagnosisService {

    @Autowired
    private TrainDateDiagnosisRepository trainDateDiagnosisRepository;

    /**
     * 保存
     *
     * @param trainDateDiagnosisModel
     */
    @Override
    public void save(CreateTrainDateDiagnosisModel trainDateDiagnosisModel){
//    public void save(trainDateDiagnosis trainDateDiagnosisModel) {
//        trainDateDiagnosisRepository.save(trainDateDiagnosisModel);
        TrainDateDiagnosis trainDateDiagnosis = new TrainDateDiagnosis();
        UpdateUtil.copyNonNullProperties(trainDateDiagnosisModel,trainDateDiagnosis);
        trainDateDiagnosisRepository.save(trainDateDiagnosis);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainDateDiagnosisModel
     */
    @Override
    public TrainDateDiagnosis save_r(CreateTrainDateDiagnosisModel trainDateDiagnosisModel){
//    public void save(trainDateDiagnosis trainDateDiagnosisModel) {
//        trainDateDiagnosisRepository.save(trainDateDiagnosisModel);
        TrainDateDiagnosis trainDateDiagnosis = new TrainDateDiagnosis();
        UpdateUtil.copyNonNullProperties(trainDateDiagnosisModel,trainDateDiagnosis);
        return trainDateDiagnosisRepository.save(trainDateDiagnosis);
    }

    /**
     * 修改
     *
     * @param trainDateDiagnosisModel
     */

    @Override
    public void update(UpdateTrainDateDiagnosisModel trainDateDiagnosisModel){
//    public void update(trainDateDiagnosis trainDateDiagnosisModel) {
        Optional<TrainDateDiagnosis> scaleItemOptional = trainDateDiagnosisRepository.findById(trainDateDiagnosisModel.getDiagnosisId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDateDiagnosisRepository.save(trainDateDiagnosisModel);
        TrainDateDiagnosis trainDateDiagnosis = new TrainDateDiagnosis();
        UpdateUtil.copyNonNullProperties(trainDateDiagnosisModel,trainDateDiagnosis);
        trainDateDiagnosisRepository.save(trainDateDiagnosis);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainDateDiagnosisModel
     */
    @Override
    public TrainDateDiagnosis update_r(UpdateTrainDateDiagnosisModel trainDateDiagnosisModel){
//    public trainDateDiagnosis update_r(trainDateDiagnosis trainDateDiagnosisModel) {
        Optional<TrainDateDiagnosis> scaleItemOptional = trainDateDiagnosisRepository.findById(trainDateDiagnosisModel.getDiagnosisId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainDateDiagnosisRepository.save(trainDateDiagnosisModel);
        TrainDateDiagnosis trainDateDiagnosis = new TrainDateDiagnosis();
        UpdateUtil.copyNonNullProperties(trainDateDiagnosisModel,trainDateDiagnosis);
        return trainDateDiagnosisRepository.save(trainDateDiagnosis);
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
            trainDateDiagnosisRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainDateDiagnosis get(String id) {
        Optional<TrainDateDiagnosis> scaleItemRepositoryOptional = trainDateDiagnosisRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainDateDiagnosis> findAll() {
        return trainDateDiagnosisRepository.findAll();
    }


    /**
     * 获取指定患者的所有日历往史
     * @return
     */
    @Override
    public List<TrainDateDiagnosis> getDataDiagnosisList(String userId){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<TrainDateDiagnosis> trainDateDiagnosisList = trainDateDiagnosisRepository.findAllByUserId(userId,sort);
        if (trainDateDiagnosisList == null||trainDateDiagnosisList.size()==0) {
            return null;
        }
        return trainDateDiagnosisList;
    }
    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDateDiagnosis> findPage(String condition, Pageable pageable) {
        return trainDateDiagnosisRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainDateDiagnosis> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainDateDiagnosis> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
