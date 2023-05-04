package org.minispring.beans.factory;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.AutowireCapableBeanFactory;
import org.minispring.beans.factory.config.BeanDefinition;
import org.minispring.beans.factory.config.BeanPostProcessor;
import org.minispring.beans.factory.config.ConfigurableBeanFactory;

/**
 * 用于配置可列举的Bean工厂的接口。它继承了HierarchicalBeanFactory和ListableBeanFactory接口，
 * 并提供了支持Bean的预处理、后置处理器、懒加载、作用域和生命周期管理等一系列功能的方法。
 */
public interface ConfigurableListableBeanFactory
        extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    //一句话总结：用于配置可列举的Bean工厂的接口


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
