package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {


    //一句话总结：简单的bean实例化实现，根据bean的无参构造函数实例化对象

    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
