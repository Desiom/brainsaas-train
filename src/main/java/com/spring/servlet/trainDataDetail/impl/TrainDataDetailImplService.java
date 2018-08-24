package com.spring.servlet.trainDataDetail.impl;

import com.spring.entity.TrainDataDetail;
import com.spring.enums.ResultEnum;
import com.spring.exception.ResultException;
import com.spring.model.trainDataDetail.CreateTrainDataDetailModel;
import com.spring.model.trainDataDetail.UpdateTrainDataDetailModel;
import com.spring.repository.TrainDataDetailRepository;
import com.spring.servlet.trainDataDetail.TrainDataDetailService;
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
public class TrainDataDetailImplService implements TrainDataDetailService {

    @Autowired
    private TrainDataDetailRepository trainDataDetailRepository;

    /**
     * 保存
     * @param trainDataDetailModel
     */
    @Override
    public void save(CreateTrainDataDetailModel trainDataDetailModel){
//    public void save(trainDataDetail trainDataDetailModel){
//        trainDataDetailRepository.save(trainDataDetailModel);
        TrainDataDetail trainDataDetail = new TrainDataDetail();
        UpdateUtil.copyNonNullProperties(trainDataDetailModel,trainDataDetail);
        trainDataDetailRepository.save(trainDataDetail);
    }

    /**
     * 保存携带返回值信息
     * @param trainDataDetailModel
     */
    @Override
    public TrainDataDetail save_r(CreateTrainDataDetailModel trainDataDetailModel){
//    public trainDataDetail save_r(trainDataDetail trainDataDetailModel){
//        return trainDataDetailRepository.save(trainDataDetailModel);
        TrainDataDetail trainDataDetail = new TrainDataDetail();
        UpdateUtil.copyNonNullProperties(trainDataDetailModel,trainDataDetail);
        return trainDataDetailRepository.save(trainDataDetail);
    }

    /**
     * 修改
     * @param trainDataDetailModel
     */

    @Override
    public void update(UpdateTrainDataDetailModel trainDataDetailModel){
//    public void update(trainDataDetail trainDataDetailModel){
        Optional<TrainDataDetail> scaleItemOptional = trainDataDetailRepository.findById(trainDataDetailModel.getDetailId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()){
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        trainDataDetailRepository.save(trainDataDetailModel);
        TrainDataDetail trainDataDetail = new TrainDataDetail();
        UpdateUtil.copyNonNullProperties(trainDataDetailModel,trainDataDetail);
        trainDataDetailRepository.save(trainDataDetail);
    }

    /**
     * 修改携带返回值信息
     * @param trainDataDetailModel
     */
    @Override
    public TrainDataDetail update_r(UpdateTrainDataDetailModel trainDataDetailModel){
//    public trainDataDetail update_r(trainDataDetail trainDataDetailModel){
        Optional<TrainDataDetail> scaleItemOptional = trainDataDetailRepository.findById(trainDataDetailModel.getDetailId());
        //判断是否存在
        if (!scaleItemOptional.isPresent()){
            throw new ResultException(ResultEnum.SAVE_ERROR);
        }
//        return trainDataDetailRepository.save(trainDataDetailModel);
        TrainDataDetail trainDataDetail = new TrainDataDetail();
        UpdateUtil.copyNonNullProperties(trainDataDetailModel,trainDataDetail);
        return trainDataDetailRepository.save(trainDataDetail);
    }

    /**
     * 删除
     * @param ids
     */
    @Override
    public void delete(String ids){
        String[] idArray =  ids.split(",");
        for (String id:idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            trainDataDetailRepository.deleteById(id);
        }
    }

    /**
     * 查找（根据ID）
     * @param id
     * @return
     */
    @Override
    public TrainDataDetail get(String id){
        Optional<TrainDataDetail> scaleItemRepositoryOptional = trainDataDetailRepository.findById(id);
        if(!scaleItemRepositoryOptional.isPresent()){
            return null;
        }
        return scaleItemRepositoryOptional.get();
    }


    @Override
    public List<TrainDataDetail> findAll(){
        return trainDataDetailRepository.findAll();
    }


    @Override
    public List<TrainDataDetail> getByMasters(List<String> masterIds){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        return trainDataDetailRepository.findAllByMasterIdIn(masterIds,sort);
    }

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDataDetail> findPage(String condition, Pageable pageable){
        return trainDataDetailRepository.findAll(new ScaleItemSpecification(condition),pageable);
    }


    /**
     *分页参数
     */
    private class ScaleItemSpecification implements Specification<TrainDataDetail> {
        private String condition;
        public ScaleItemSpecification(String condition){
            this.condition = condition;
        }

        @Override
        public Predicate toPredicate(Root<TrainDataDetail> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(StringUtils.isBlank(condition)){
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("item_title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name,"%" + condition + "%"));
            return predicate;
        }
    }

}
