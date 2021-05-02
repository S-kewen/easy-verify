package com.cloud.easyverify.dao;

import com.cloud.easyverify.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PackageName: com.cloud.easyverify.dao
 * @ClassName: UserDao
 * @Description: This is UserDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:43
 */
@Mapper
public interface UserDao {
    int insertOne(User user);
    User selectOne(User user);
    int getCount(User user);
    int updateOne(User user);
    User getById(User user);
}
