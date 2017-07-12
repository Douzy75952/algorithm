package com.thinkjoy.service.impl.report;

import com.thinkjoy.report.dao.ZgkUniversityMapper;
import com.thinkjoy.report.entity.ZgkUniversity;
import com.thinkjoy.service.api.report.ZgkUniversityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by douzy on 17/5/3.
 */
@Service
public class ZgkUniversityServiceImpl implements ZgkUniversityService {

    @Resource
    ZgkUniversityMapper zgkUniversityMapper;

    @Override
    public List<ZgkUniversity> selectZgkUniversitys(Map map) {
        return zgkUniversityMapper.selectList(map);
    }
}
