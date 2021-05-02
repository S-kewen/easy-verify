package com.cloud.easyverify.service;

import com.cloud.easyverify.dao.UserDao;
import com.cloud.easyverify.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.cloud.easyverify.service
 * @ClassName: UserServiceImpl
 * @Description: This is UserServiceImpl class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:45
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public int insertOne(User user) {
        return userDao.insertOne(user);
    }

    @Override
    public User selectOne(User user) {
        return userDao.selectOne(user);
    }

    @Override
    public int getCount(User user) {
        return userDao.getCount(user);
    }

    @Override
    public int updateOne(User user) {
        return userDao.updateOne(user);
    }

    @Override
    public User getById(User user) {
        return userDao.getById(user);
    }
}
