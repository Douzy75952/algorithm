package com.thinkjoy.service.api.report;

import com.thinkjoy.report.entity.ZgkUniversityEnrollingAlgorithm;

import java.util.List;
import java.util.Map;

/**
 * Created by douzy on 17/2/7.
 */
public interface AlgorithmService {

    ZgkUniversityEnrollingAlgorithm selectModel(Map map);

    /**
     * 根据分数计算最高分、最低分、平均分排名
     * @return
     */
    boolean algorithmStandardRank();

    boolean algorithmStandardLowScoreRank();
    boolean algorithmStandardAvgScoreRank();


    /**
     * 标准排名
     * @return
     */
    boolean algorithmStandardRankByScoreRank();

    /**
     * 计算均值与标准差
     * @return
     */
    boolean algotithmAvgAndDiff();

    /**
     * 获取历年年份集
     * @return
     */
    List<String> getEnrollYear();

    /**
     * 获取分组区域信息
     * @return
     */
    List<String> getEnrollingArea();

    /**
     * 更新计算数值表
     * @param model
     * @return
     */
    boolean updateAlgorithmRank(ZgkUniversityEnrollingAlgorithm model);

    /**
     * 获取分组批次信息
     * @return
     */
    List<String> getEnrollBatch();

    /**
     * 获取分组文理科信息
     * @return
     */
    List<String> getMajorType();
}
