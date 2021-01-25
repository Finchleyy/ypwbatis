package com.ypw.batis.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * @author yupengwu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface YpwSql {
    String sql();

    String type() default "";
}
