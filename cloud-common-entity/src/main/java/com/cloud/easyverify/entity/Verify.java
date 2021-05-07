package com.cloud.easyverify.entity;

import lombok.Data;

import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.entity
 * @ClassName: Verify
 * @Description: This is Verify class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-07 9:42
 */
@Data
public class Verify {
    private long id;
    private String uuid;
    private long uid;
    private long sid;
    private long tid;
    private int type;
    private int state;
    private int tryCount;
    private int tryTotal;
    private String ip;
    private String code;
    private String email;
    private String title;
    private String content;
    private Date expireTime;
    private String remark;
    private Date addTime;
}
