package com.cloud.easyverify.entity;

import lombok.Data;

import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.entity
 * @ClassName: Token
 * @Description: This is Token class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 20:22
 */
@Data
public class Token {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Date expireTime;
    private Date addTime;
}
