package com.spring.servlet.trainSetmealInforList.impl;

import com.spring.entity.TrainSetmealInforList;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainSetmealInforList.CreateTrainSetmealInforListModel;
import com.spring.model.trainSetmealInforList.UpdateTrainSetmealInforListModel;
import com.spring.repository.TrainSetmealInforListRepository;
import com.spring.servlet.trainSetmealInforList.TrainSetmealInforListService;
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
public class TrainSetmealInforListImplService implements TrainSetmealInforListService {

    @Autowired
    private TrainSetmealInforListRepository trainSetmealInforListRepository;

    /**
     * 保存
     *
     * @param trainSetmealInforListModel
     */
    @Override
    public void save(CreateTrainSetmealInforListModel trainSetmealInforListModel){
//    public void save(trainSetmealInforList trainSetmealInforListModel) {
//        trainSetmealInforListRepository.save(trainSetmealInforListModel);
        TrainSetmealInforList trainSetmealInforList = new TrainSetmealInforList();
        UpdateUtil.copyNonNullProperties(trainSetmealInforListModel,trainSetmealInforList);
        trainSetmealInforListRepository.save(trainSetmealInforList);
    }

    /**
     * 保存携带返回值信息
     *
     * @param trainSetmealInforListModel
     */
    @Override
    public TrainSetmealInforList save_r(CreateTrainSetmealInforListModel trainSetmealInforListModel){
//    public trainSetmealInforList save_r(trainSetmealInforList trainSetmealInforListModel) {
//        return trainSetmealInforListRepository.save(trainSetmealInforListModel);
        TrainSetmealInforList trainSetmealInforList = new TrainSetmealInforList();
        UpdateUtil.copyNonNullProperties(trainSetmealInforListModel,trainSetmealInforList);
        return trainSetmealInforListRepository.save(trainSetmealInforList);
    }

    /**
     * 修改
     *
     * @param trainSetmealInforListModel
     */

    @Override
    public void update(UpdateTrainSetmealInforListModel trainSetmealInforListModel){
//    public void update(trainSetmealInforList trainSetmealInforListModel) {
        Optional<TrainSetmealInforList> scaleItemOptional = trainSetmealInforListRepository.findById(trainSetmealInforListModel.getSetmealInforId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainSetmealInforListRepository.save(trainSetmealInforListModel);
        TrainSetmealInforList trainSetmealInforList = new TrainSetmealInforList();
        UpdateUtil.copyNonNullProperties(trainSetmealInforListModel,trainSetmealInforList);
        trainSetmealInforListRepository.save(trainSetmealInforList);
    }

    /**
     * 修改携带返回值信息
     *
     * @param trainSetmealInforListModel
     */
    @Override
    public TrainSetmealInforList update_r(UpdateTrainSetmealInforListModel trainSetmealInforListModel){
//    public trainSetmealInforList update_r(trainSetmealInforList trainSetmealInforListModel) {
        Optional<TrainSetmealInforList> scaleItemOptional = trainSetmealInforListRepository.findById(trainSetmealInforListModel.getSetmealInforId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()) {
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainSetmealInforListRepository.save(trainSetmealInforListModel);
        TrainSetmealInforList trainSetmealInforList = new TrainSetmealInforList();
        UpdateUtil.copyNonNullProperties(trainSetmealInforListModel,trainSetmealInforList);
        return trainSetmealInforListRepository.save(trainSetmealInforList);
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
            trainSetmealInforListRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     *
     * @param id
     * @return
     */
    @Override
    public TrainSetmealInforList get(String id) {
        Optional<TrainSetmealInforList> scaleItemRepositoryOptional = trainSetmealInforListRepository.findById(id);
        if (!scaleItemRepositoryOptional.isPresent()) {
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainSetmealInforList> findAll() {
        return trainSetmealInforListRepository.findAll();
    }

    /**
     * 分页查找
     *
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainSetmealInforList> findPage(String condition, Pageable pageable) {
        return trainSetmealInforListRepository.findAll(new ScaleItemSpecification(condition), pageable);
    }


    /**
     * 分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainSetmealInforList> {
        private String condition;

        public ScaleItemSpecification(String condition) {
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainSetmealInforList> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
