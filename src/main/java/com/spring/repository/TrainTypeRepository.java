package com.spring.repository;

import com.spring.entity.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Desiom on 2018/6/5.
 */
public interface TrainTypeRepository extends JpaRepository<TrainType,Integer>,JpaSpecificationExecutor<TrainType> {

}
