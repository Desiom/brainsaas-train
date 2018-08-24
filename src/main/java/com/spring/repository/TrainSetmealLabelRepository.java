package com.spring.repository;

import com.spring.entity.TrainSetmealLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainSetmealLabelRepository extends JpaRepository<TrainSetmealLabel,String>,JpaSpecificationExecutor<TrainSetmealLabel> {

}
