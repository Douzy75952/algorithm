package com.thinkjoy.service.api.report;

import com.thinkjoy.report.entity.ZgkUniversity;

import java.util.List;
import java.util.Map;

/**
 * Created by douzy on 17/5/3.
 */
public interface ZgkUniversityService {

    /**
     * 院校列表
     * @return
     */
    List<ZgkUniversity> selectZgkUniversitys(Map map);
}
