package org.minispring.beans.factory.config;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition的属性值
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有BeanDefintion加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
