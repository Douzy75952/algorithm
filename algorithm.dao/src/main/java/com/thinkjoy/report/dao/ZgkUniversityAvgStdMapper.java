package com.thinkjoy.report.dao;

import com.thinkjoy.base.framework.BaseMapper;
import com.thinkjoy.report.entity.ZgkUniversityAvgStd;

import java.util.List;

/**
 * Created by douzy on 17/3/15.
 */
public interface ZgkUniversityAvgStdMapper extends BaseMapper<ZgkUniversityAvgStd,Integer> {

    Integer addStds(List<ZgkUniversityAvgStd> zgkUniversityAvgStdList);
}
