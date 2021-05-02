package com.cloud.easyverify.handler;

import com.cloud.easyverify.result.MyResult;
import com.cloud.easyverify.result.ResultMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @PackageName: com.cloud.easyverify.handler
 * @ClassName: ExceptionHandler
 * @Description: This is ExceptionHandler class by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 20:08
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MyResult defaultErrorHandler(HttpServletRequest request, Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("query", request.getQueryString());
        map.put("method", request.getMethod());
        map.put("contextPath", request.getContextPath());
        map.put("errorMsg", e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return new MyResult(ResultMsg.SYS_NOTFOUND, map);
        } else {
            return new MyResult(ResultMsg.SYS_ERROR, map);
        }
    }
}
