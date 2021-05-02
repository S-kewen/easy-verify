package com.cloud.easyverify.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @PackageName: com.cloud.easyverify.annotation
 * @ClassName: PassToken
 * @Description: This is PassToken interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-05-02 21:07
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
