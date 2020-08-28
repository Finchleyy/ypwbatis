package com.ypw.batis.core.component;

import com.ypw.batis.core.annotation.YpwMapperScan;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

/**
 * 注入 beanDefinition
 *
 * @author yupengwu
 */
public class YpwBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(YpwMapperScan.class.getName());
        Object path = annotationAttributes.get("path");
        System.out.println("path=========>" + path);
        //构造 beandefinition
        /*List<Class> mappers = new ArrayList<>();
        mappers.add(TestMapper.class);
        for (Class mapper : mappers) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinition.setBeanClass(YpwFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
            //注册到 spring 容器中
            registry.registerBeanDefinition(mapper.getName(), beanDefinition);
        }*/
        /**
         * 这个是 Mybatis 中的处理方法
         * public class ClassPathMapperScanner extends ClassPathBeanDefinitionScanner {
         *
         * public Set<BeanDefinitionHolder> doScan(String... basePackages) {
         *         Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
         *         if (beanDefinitions.isEmpty()) {
         *             this.logger.warn("No MyBatis mapper was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
         *         } else {
         *             this.processBeanDefinitions(beanDefinitions);
         *         }
         *
         *         return beanDefinitions;
         *     }
         *
         */
        //扫描路径 构造 beandefinition
        YpwClassPathMapperScanner ypwClassPathMapperScanner = new YpwClassPathMapperScanner(registry);
        //FIXME 暂时无法扫描到 mapper?? 因为没有 includeFilter不会被扫描注入到 spring中
        ypwClassPathMapperScanner.registerFilters();
        Set<BeanDefinitionHolder> beanDefinitions = ypwClassPathMapperScanner.doScan(path.toString());
        if (beanDefinitions.isEmpty()) {
            System.out.println("No YpwBatis mapper was found in '" + path + "' package. Please check your configuration.");
        } else {
            for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitions) {
                GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
                beanDefinition.setBeanClass(YpwFactoryBean.class);
                //给BeanDefinition构造器参数传值 设置 bean 的名称
                beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getClass().getName());
            }
        }
    }


}
