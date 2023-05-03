package org.minispring.beans.factory.config;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.BeanFactory;

/**
 * AutowireCapableBeanFactory是Spring框架中的一个接口，继承自BeanFactory接口，
 * 并提供了自动装配的能力。具体来说，它可以创建Bean对象并自动装配Bean的依赖关系，包括构造函数、属性和方法等。
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

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
