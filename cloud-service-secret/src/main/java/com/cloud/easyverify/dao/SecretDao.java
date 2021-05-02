package com.cloud.easyverify.dao;

import com.cloud.easyverify.entity.Secret;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.dao
 * @ClassName: SecretDao
 * @Description: This is SecretDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:34
 */
@Mapper
public interface SecretDao {
    int insertOne(Secret secret);
    Secret getBySecret(Secret secret);
    List<Map<String, Object>> list(Secret secret);
    int deleteOne(Secret secret);
    int updateOne(Secret secret);
    Secret selectOne(Secret secret);
}
