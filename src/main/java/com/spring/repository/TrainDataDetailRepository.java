package com.spring.repository;

import com.spring.entity.TrainDataDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Desiom on 2018/6/5.
 */
public interface TrainDataDetailRepository extends JpaRepository<TrainDataDetail,String>,JpaSpecificationExecutor<TrainDataDetail> {

    List<TrainDataDetail> findAllByMasterIdIn(List<String> masterIds, Sort sort);
}
