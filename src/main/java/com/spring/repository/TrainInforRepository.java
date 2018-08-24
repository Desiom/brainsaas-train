package com.spring.repository;

import com.spring.entity.TrainInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Desiom on 2018/6/5.
 */
public interface TrainInforRepository extends JpaRepository<TrainInfor,Integer>,JpaSpecificationExecutor<TrainInfor> {

}
