package org.minispring.beans.factory.config;

import org.minispring.beans.BeansException;
import org.minispring.beans.PropertyValues;


/**
 * 用于扩展Bean实例化过程的接口。它继承了BeanPostProcessor接口，并增加了一些额外的扩展方法。
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    //一句话总结：扩展Bean实例化过程的接口


    /**
     * 在bean实例化之前执行
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName)
            throws BeansException;

    /**
     * 提前暴露bean
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
