package com.cloud.easyverify.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName: com.cloud.easyverify.entity
 * @ClassName: Template
 * @Description: This is Template class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-04 18:17
 */
@Data
public class Template implements Serializable {
    private long id;
    private long uid;
    private int type;
    private int state;
    private String title;
    private String content;
    private int codeType;
    private int codeLen;
    private int tryTotal;
    private int validTime;
    private String remark;
    private Date addTime;
}
