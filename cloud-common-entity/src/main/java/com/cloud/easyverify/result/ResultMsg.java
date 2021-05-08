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
    SECRET_CREATEFAIL(-2000,"create fail"),
    SECRET_DELETEFAIL(-2001,"delete fail"),
    SECRET_UPDATEFAIL(-2002,"update fail"),
    SECRET_SELECTFAIL(-2002,"select fail"),
    /* TEMPLATE */
    TEMPLATE_CREATEFAIL(-3000,"create fail"),
    TEMPLATE_DELETEFAIL(-3001,"delete fail"),
    TEMPLATE_UPDATEFAIL(-3002,"update fail"),
    TEMPLATE_SYMBOLNOTEXIST(-3003,"symbol does not exist"),
    /* VERIFY */
    VERIFY_CREATEFAIL(-3000,"create fail"),
    VERIFY_DELETEFAIL(-3001,"delete fail"),
    VERIFY_UPDATEFAIL(-3002,"update fail"),
    VERIFY_SELECTFAIL(-3003,"select fail"),
    /* API */
    API_SECRETINVALID(-4000,"secret invaild"),
    API_SECRETEXPIRED(-4001,"secret expired"),
    API_TEMPLATEERROR(-4002,"tamplate error"),
    API_TEMPLATESTATEEERROR(-4003,"tamplate state error"),
    API_SYSTEMBUSY(-4004,"system busy"),
    API_SENDFAIL(-4005,"send email fail"),
    API_UUIDERROR(-4006,"uuid error"),
    API_VERIFYEXPIRED(-4007,"code expired"),
    API_CODEERROR(-4008,"code error")
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
