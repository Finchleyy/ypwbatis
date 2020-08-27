package com.ypw.batis.core.component;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用 FactoryBean 生成动态代理的 Bean
 *
 * @author yupengwu
 */
public class YpwFactoryBean implements FactoryBean {
    private Class clazz;

    public YpwFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Object proxyInstance = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("befor proxy.....");
                System.out.println(method.getName());
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                return null;
            }
        });
        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
