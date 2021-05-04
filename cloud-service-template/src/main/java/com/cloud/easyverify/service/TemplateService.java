package com.cloud.easyverify.service;

import com.cloud.easyverify.entity.Template;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service
 * @ClassName: TemplateService
 * @Description: This is TemplateService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:19
 */
public interface TemplateService {
    int insertOne(Template template);
    List<Map<String, Object>> list(Template template);
    int deleteOne(Template template);
    int updateOne(Template template);
    Template selectOne(Template template);
}
