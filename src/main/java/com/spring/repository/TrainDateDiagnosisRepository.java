package com.spring.repository;

import com.spring.entity.TrainDateDiagnosis;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDateDiagnosisRepository extends JpaRepository<TrainDateDiagnosis,String>,JpaSpecificationExecutor<TrainDateDiagnosis> {

    /**
     * 获取指定患者的所有日历往史
     * @return
     */
    List<TrainDateDiagnosis> findAllByUserId(String userId, Sort sort);
}
