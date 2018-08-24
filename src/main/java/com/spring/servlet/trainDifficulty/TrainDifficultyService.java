package com.spring.servlet.trainDifficulty;

import com.spring.entity.TrainDifficulty;
import com.spring.model.trainDifficulty.CreateTrainDifficultyModel;
import com.spring.model.trainDifficulty.UpdateTrainDifficultyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrainDifficultyService {

    /**
     * 保存
     * @param trainDifficultyModel
     */
    public void save(CreateTrainDifficultyModel trainDifficultyModel);
//    public void save(trainDifficulty trainDifficultyModel);

    /**
     * 保存携带返回值信息
     * @param trainDifficultyModel
     */
    public TrainDifficulty save_r(CreateTrainDifficultyModel trainDifficultyModel);
//    public trainDifficulty save_r(trainDifficulty trainDifficultyModel);

    /**
     * 修改
     * @param trainDifficultyModel
     */
    public void update(UpdateTrainDifficultyModel trainDifficultyModel);
//    public void update(trainDifficulty trainDifficultyModel);

    /**
     * 修改携带返回值信息
     * @param trainDifficultyModel
     */
    public TrainDifficulty update_r(UpdateTrainDifficultyModel trainDifficultyModel);
//    public trainDifficulty update_r(trainDifficulty trainDifficultyModel);


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
    public TrainDifficulty get(Integer id);


    /**
     * 获取所有
     * @return
     */
    public List<TrainDifficulty> findAll();

    /**
     * 分页查找
     * @param condition
     * @param pageable
     * @return
     */
    public Page<TrainDifficulty> findPage(String condition, Pageable pageable);


}
