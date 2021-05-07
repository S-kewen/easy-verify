package com.cloud.easyverify.service.impl;

import com.cloud.easyverify.dao.VerifyDao;
import com.cloud.easyverify.entity.Verify;
import com.cloud.easyverify.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.easyverify.service.impl
 * @ClassName: VerifyServiceImpl
 * @Description: This is VerifyServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 9:57
 */
@Service
public class VerifyServiceImpl implements VerifyService {
    @Autowired
    private VerifyDao verifyDao;
    @Override
    public int insertOne(Verify verify) {
        return verifyDao.insertOne(verify);
    }

    @Override
    public Verify selectOne(Verify verify) {
        return verifyDao.selectOne(verify);
    }

    @Override
    public int updateOne(Verify verify) {
        return verifyDao.updateOne(verify);
    }

    @Override
    public Verify getById(Verify verify) {
        return verifyDao.getById(verify);
    }

    @Override
    public List<Map<String, Object>> list(Verify verify) {
        return verifyDao.list(verify);
    }

    @Override
    public int deleteOne(Verify verify) {
        return verifyDao.deleteOne(verify);
    }
}
