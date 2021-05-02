package com.cloud.easyverify.service.impl;

import com.cloud.easyverify.dao.SecretDao;
import com.cloud.easyverify.entity.Secret;
import com.cloud.easyverify.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service.impl
 * @ClassName: SecretServiceImpl
 * @Description: This is SecretServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:46
 */
@Service
public class SecretServiceImpl implements SecretService {
    @Autowired
    private SecretDao secretDao;
    @Override
    public int insertOne(Secret secret) {
        return secretDao.insertOne(secret);
    }

    @Override
    public Secret getBySecret(Secret secret) {
        return secretDao.getBySecret(secret);
    }

    @Override
    public List<Map<String, Object>> list(Secret secret) {
        return secretDao.list(secret);
    }

    @Override
    public int deleteOne(Secret secret) {
        return secretDao.deleteOne(secret);
    }

    @Override
    public int updateOne(Secret secret) {
        return secretDao.updateOne(secret);
    }

    @Override
    public Secret selectOne(Secret secret) {
        return secretDao.selectOne(secret);
    }
}
