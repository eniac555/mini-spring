package org.minispring.beans.factory.config;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.BeanFactory;

/**
 用于实现自动装配功能的接口，它提供了实现自动装配、Bean后置处理器、懒加载、AOP和Bean的生命周期管理等一系列功能的方法
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    //一句话总结：用于实现自动装配功能的接口

    /**
     * 执行BeanPostProcessors的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;

    /**
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
