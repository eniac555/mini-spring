package org.minispring.beans.factory;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.AutowireCapableBeanFactory;
import org.minispring.beans.factory.config.BeanDefinition;
import org.minispring.beans.factory.config.BeanPostProcessor;
import org.minispring.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
