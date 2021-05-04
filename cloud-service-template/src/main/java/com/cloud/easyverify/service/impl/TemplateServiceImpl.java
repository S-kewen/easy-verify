package com.cloud.easyverify.service.impl;

import com.cloud.easyverify.dao.TemplateDao;
import com.cloud.easyverify.entity.Template;
import com.cloud.easyverify.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service.impl
 * @ClassName: TemplateServiceImpl
 * @Description: This is TemplateServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:26
 */
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao templateDao;
    @Override
    public int insertOne(Template template) {
        return templateDao.insertOne(template);
    }

    @Override
    public List<Map<String, Object>> list(Template template) {
        return templateDao.list(template);
    }

    @Override
    public int deleteOne(Template template) {
        return templateDao.deleteOne(template);
    }

    @Override
    public int updateOne(Template template) {
        return templateDao.updateOne(template);
    }

    @Override
    public Template selectOne(Template template) {
        return templateDao.selectOne(template);
    }
}
