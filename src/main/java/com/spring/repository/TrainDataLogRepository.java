package com.spring.repository;

import com.spring.entity.TrainDataLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDataLogRepository extends JpaRepository<TrainDataLog,String>,JpaSpecificationExecutor<TrainDataLog> {


}
