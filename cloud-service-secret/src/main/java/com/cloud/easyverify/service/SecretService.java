package com.cloud.easyverify.service;

import com.cloud.easyverify.entity.Secret;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service
 * @ClassName: SecretService
 * @Description: This is SecretService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:33
 */
public interface SecretService {
    int insertOne(Secret secret);
    Secret getBySecret(Secret secret);
    List<Map<String, Object>> list(Secret secret);
    int deleteOne(Secret secret);
    int updateOne(Secret secret);
    Secret selectOne(Secret secret);
}
