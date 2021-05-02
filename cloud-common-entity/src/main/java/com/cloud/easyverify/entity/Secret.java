package com.cloud.easyverify.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.entity
 * @ClassName: Secret
 * @Description: This is Secret class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:35
 */
@Data
public class Secret implements Serializable {
    private long id;
    private long uid;
    private int type;
    private int state;
    private String secret;
    private Date expireTime;
    private String remark;
    private Date addTime;
}
