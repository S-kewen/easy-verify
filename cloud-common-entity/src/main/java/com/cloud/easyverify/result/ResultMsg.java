package com.cloud.easyverify.result;


public enum ResultMsg {
    SUCCESS(200,"success"),
    /* USER */
    USER_EXISTED(-1000,"username exist"),
    USER_LOGINFAIL(-1001,"username or password error"),
    USER_REGISTERFAIL(-1002,"register fail"),
    /* SYSTEM */
    SYS_NOTFOUND(404,"not found"),
    SYS_ERROR(500,"system error")
    ;
    private Integer code;
    private String msg;

    ResultMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
