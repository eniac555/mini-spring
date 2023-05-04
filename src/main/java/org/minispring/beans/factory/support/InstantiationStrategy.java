package org.minispring.beans.factory.support;


import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 * bean的实例化策略
 */
public interface InstantiationStrategy {

    //一句话总结：用于Bean实例化策略的接口。它定义了Bean实例化的方法，具体实现由其子类实现。
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
