package com.cloud.easyverify.result;


public enum ResultMsg {
    SUCCESS(200,"success"),
    /* USER */
    USER_EXISTED(-1000,"username exist"),
    USER_LOGINFAIL(-1001,"username or password error"),
    USER_REGISTERFAIL(-1002,"register fail"),
    USER_LIMITLOGIN(-1003,"limit login"),
    USER_ACCESSERROR(-1004,"token invalid,please login again"),
    USER_USERNOTEXIST(-1005,"user not exist"),
    /* SYSTEM */
    SYS_NOTFOUND(404,"not found"),
    SYS_ERROR(500,"system error"),
    /* SECRET */
    SECRET_CREATEFAIL(-2000,"create faill"),
    SECRET_DELETEFAIL(-2001,"delete faill"),
    SECRET_UPDATEFAIL(-2002,"update faill"),
    /* TEMPLATE */
    TEMPLATE_CREATEFAIL(-3000,"create faill"),
    TEMPLATE_DELETEFAIL(-3001,"delete faill"),
    TEMPLATE_UPDATEFAIL(-3002,"update faill"),
    TEMPLATE_SYMBOLNOTEXIST(-3003,"symbol does not exist"),
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
