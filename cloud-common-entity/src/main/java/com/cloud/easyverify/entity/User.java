package com.cloud.easyverify.entity;

import lombok.Data;

import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.entity
 * @ClassName: User
 * @Description: This is User class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:27
 */
@Data
public class User {
    private long id;
    private int type;
    private int state;
    private String username;
    private String password;
    private String authorization;
    private String remark;
    private Date addTime;
}
