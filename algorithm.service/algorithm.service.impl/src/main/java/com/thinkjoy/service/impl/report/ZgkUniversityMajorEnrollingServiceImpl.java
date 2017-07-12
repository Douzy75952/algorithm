package com.thinkjoy.service.impl.report;

import com.thinkjoy.report.dao.ZgkUniversityEnrollingMapper;
import com.thinkjoy.report.dao.ZgkUniversityMajorEnrollingMapper;
import com.thinkjoy.report.entity.ZgkUniversityEnrolling;
import com.thinkjoy.report.entity.ZgkUniversityMajorEnrolling;
import com.thinkjoy.service.api.report.ZgkUniversityEnrollingService;
import com.thinkjoy.service.api.report.ZgkUniversityMajorEnrollingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by douzy on 17/5/3.
 */
@Service
public class ZgkUniversityMajorEnrollingServiceImpl implements ZgkUniversityMajorEnrollingService {

    @Resource
    ZgkUniversityMajorEnrollingMapper zgkUniversityMajorEnrollingMapper;

    @Override
    public Integer insertUniversityMajorEnrollingList(List<ZgkUniversityMajorEnrolling> zgkUniversityEnrollingList) {
        return zgkUniversityMajorEnrollingMapper.insertUniversityMajorEnrollingList(zgkUniversityEnrollingList);
    }

    @Override
    public Integer insert(ZgkUniversityMajorEnrolling zgkUniversityEnrollingList) {
        return zgkUniversityMajorEnrollingMapper.insert(zgkUniversityEnrollingList);
    }
}
