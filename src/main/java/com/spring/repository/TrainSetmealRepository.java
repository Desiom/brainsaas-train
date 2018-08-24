package com.spring.repository;

import com.spring.entity.TrainSetmeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainSetmealRepository extends JpaRepository<TrainSetmeal,String>,JpaSpecificationExecutor<TrainSetmeal> {

}
