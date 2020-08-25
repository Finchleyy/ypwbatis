package com.ypw.batis.core.annotation;

import com.ypw.batis.core.component.YpwBeanDefinitionRegistry;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author yupengwu
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(YpwBeanDefinitionRegistry.class)
public @interface YpwMapperScan {
    String path() default "";
}