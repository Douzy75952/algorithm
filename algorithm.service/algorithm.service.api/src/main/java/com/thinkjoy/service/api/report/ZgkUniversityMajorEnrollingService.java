package com.thinkjoy.service.api.report;

import com.thinkjoy.report.entity.ZgkUniversityEnrolling;
import com.thinkjoy.report.entity.ZgkUniversityMajorEnrolling;

import java.util.List;

/**
 * Created by douzy on 17/5/3.
 */
public interface ZgkUniversityMajorEnrollingService {

    Integer insertUniversityMajorEnrollingList(List<ZgkUniversityMajorEnrolling> zgkUniversityEnrollingList);

    Integer insert(ZgkUniversityMajorEnrolling zgkUniversityEnrolling);

}
