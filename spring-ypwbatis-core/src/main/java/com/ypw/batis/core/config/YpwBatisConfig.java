package com.ypw.batis.core.config;

import com.ypw.batis.core.annotation.YpwMapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yupengwu
 */
@Configuration
//@ComponentScan(basePackages = "com.ypw.batis")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@YpwMapperScan(path = "com.ypw.batis.core.mapper")
public class YpwBatisConfig {

}
