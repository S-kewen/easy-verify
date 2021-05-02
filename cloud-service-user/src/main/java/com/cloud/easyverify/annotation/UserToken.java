package com.cloud.easyverify.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @PackageName: com.cloud.easyverify.annotation
 * @ClassName: UserToken
 * @Description: This is UserToken interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:06
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserToken {
    boolean required() default true;
}
