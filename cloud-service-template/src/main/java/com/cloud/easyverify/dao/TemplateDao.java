package com.cloud.easyverify.dao;

import com.cloud.easyverify.entity.Secret;
import com.cloud.easyverify.entity.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.dao
 * @ClassName: TemplateDao
 * @Description: This is TemplateDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:19
 */
@Mapper
public interface TemplateDao {
    int insertOne(Template template);
    List<Map<String, Object>> list(Template template);
    int deleteOne(Template template);
    int updateOne(Template template);
    Template selectOne(Template template);
}
