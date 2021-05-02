package com.cloud.easyverify.service;

import com.cloud.easyverify.entity.User;

/**
 * @PackageName: com.cloud.easyverify.service
 * @ClassName: UserService
 * @Description: This is UserService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:45
 */
public interface UserService {
    int insertOne(User user);
    User selectOne(User user);
    int getCount(User user);
    int updateOne(User user);
    User getById(User user);
}
