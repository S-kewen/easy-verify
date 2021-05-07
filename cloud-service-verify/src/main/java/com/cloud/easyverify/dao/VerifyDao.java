package com.cloud.easyverify.dao;

import com.cloud.easyverify.entity.Secret;
import com.cloud.easyverify.entity.User;
import com.cloud.easyverify.entity.Verify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.dao
 * @ClassName: VerifyDao
 * @Description: This is VerifyDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 9:45
 */
@Mapper
public interface VerifyDao {
    int insertOne(Verify verify);
    Verify selectOne(Verify verify);
    int updateOne(Verify verify);
    Verify getById(Verify verify);
    List<Map<String, Object>> list(Verify verify);
    int deleteOne(Verify verify);
}
