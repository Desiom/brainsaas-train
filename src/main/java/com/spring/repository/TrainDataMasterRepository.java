package com.spring.repository;

import com.spring.entity.TrainDataMaster;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDataMasterRepository extends JpaRepository<TrainDataMaster,String>,JpaSpecificationExecutor<TrainDataMaster> {

    List<TrainDataMaster> findByUserId(String userId,Sort sort);
}
