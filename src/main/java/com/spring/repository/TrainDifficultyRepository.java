package com.spring.repository;

import com.spring.entity.TrainDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDifficultyRepository extends JpaRepository<TrainDifficulty,Integer>,JpaSpecificationExecutor<TrainDifficulty> {


}
