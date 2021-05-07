package com.cloud.easyverify.service;

import com.cloud.easyverify.entity.Verify;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service
 * @ClassName: VerifyService
 * @Description: This is VerifyService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 9:57
 */
public interface VerifyService {
    int insertOne(Verify verify);
    Verify selectOne(Verify verify);
    int updateOne(Verify verify);
    Verify getById(Verify verify);
    List<Map<String, Object>> list(Verify verify);
    int deleteOne(Verify verify);
}
