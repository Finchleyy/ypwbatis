package com.ypw.batis.core.component;

import com.ypw.batis.core.mapper.TestMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yupengwu
 */
/*@Component
public class YpwBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //将userServiceImpl的 beanDefinition 替换为 TestServiceImpl
        *//*GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("userServiceImpl");
        System.out.println(genericBeanDefinition.getBeanClassName());
        genericBeanDefinition.setBeanClass(TestServiceImpl.class);*//*
        //构造 beandefinition
        *//*List<Class> mappers = new ArrayList<>();
        mappers.add(TestMapper.class);
        for (Class mapper : mappers) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            beanDefinition.setBeanClass(YpwFactoryBean.class);
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);

        }*//*

    }
}*/
