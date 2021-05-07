package com.cloud.easyverify.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PackageName: com.cloud.easyverify.result
 * @ClassName: MyResult
 * @Description: This is MyResult class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 19:30
 */
@Data
@NoArgsConstructor
public class MyResult {
    private Integer code;

    private String msg;

    private long timestamp = System.currentTimeMillis() / 1000;

    private Object data;


    public MyResult(ResultMsg resultMsg) {
        this.code = resultMsg.getCode();
        this.msg = resultMsg.getMsg();

    }

    public MyResult(ResultMsg resultMsg, Object data) {
        this.code = resultMsg.getCode();
        this.msg = resultMsg.getMsg();
        this.data = data;
    }

    public MyResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
