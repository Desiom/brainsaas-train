package com.spring.servlet.trainDateDiagnosis;

import com.spring.entity.TrainDateDiagnosis;
import com.spring.model.trainDateDiagnosis.CreateTrainDateDiagnosisModel;
import com.spring.model.trainDateDiagnosis.UpdateTrainDateDiagnosisModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainDateDiagnosisService {

    /**
     * 保存
     * @param trainDateDiagnosisModel
     */
    public void save(CreateTrainDateDiagnosisModel trainDateDiagnosisModel);
//    public void save(trainDateDiagnosis trainDateDiagnosisModel);

    /**
     * 保存携带返回值信息
     * @param trainDateDiagnosisModel
     */
    public TrainDateDiagnosis save_r(CreateTrainDateDiagnosisModel trainDateDiagnosisModel);
//    public trainDateDiagnosis save_r(trainDateDiagnosis trainDateDiagnosisModel);

    /**
     * 修改
     * @param trainDateDiagnosisModel
     */
    public void update(UpdateTrainDateDiagnosisModel trainDateDiagnosisModel);
//    public void update(trainDateDiagnosis trainDateDiagnosisModel);

    /**
     * 修改携带返回值信息
     * @param trainDateDiagnosisModel
     */
    public TrainDateDiagnosis update_r(UpdateTrainDateDiagnosisModel trainDateDiagnosisModel);
//    public trainDateDiagnosis update_r(trainDateDiagnosis trainDateDiagnosisModel);


    /**
     * 删除
     * @param ids
     */
    public void delete(String ids);

    /**
     * 获取（根据ID）
     * @param id
     * @return
     */
    public TrainDateDiagnosis get(String id);

    /**
     * 获取所有
     * @return
     */
    public List<TrainDateDiagnosis> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDateDiagnosis> findPage(String condition, Pageable pageable);

    /**
     * 获取指定患者的所有日历往史
     * @return
     */
    public List<TrainDateDiagnosis> getDataDiagnosisList(String userId);
}
