package com.thinkjoy.service.impl.report;

import com.thinkjoy.report.dao.ZgkUniversityEnrollingMapper;
import com.thinkjoy.report.entity.ZgkUniversityEnrolling;
import com.thinkjoy.service.api.report.ZgkUniversityEnrollingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by douzy on 17/5/3.
 */
@Service
public class ZgkUniversityEnrollingServiceImpl implements ZgkUniversityEnrollingService {

    @Resource
    ZgkUniversityEnrollingMapper zgkUniversityEnrollingMapper;

    @Override
    public Integer insertUniversityEnrollingList(List<ZgkUniversityEnrolling> zgkUniversityEnrollingList) {
        return zgkUniversityEnrollingMapper.insertUniversityEnrollingList(zgkUniversityEnrollingList);
    }
}
