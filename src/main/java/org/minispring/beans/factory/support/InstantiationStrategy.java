package org.minispring.beans.factory.support;


import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 * bean的实例化策略
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
