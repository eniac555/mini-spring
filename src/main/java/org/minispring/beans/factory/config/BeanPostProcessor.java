package org.minispring.beans.factory.config;

import org.minispring.beans.BeansException;

/**
 * 用于修改实例化后的bean的修改扩展点
 * Bean后置处理器，是对生成的Bean对象进行修改
 */
public interface BeanPostProcessor {


    //一句话总结：Bean后置处理器，是对生成的Bean对象进行修改


    /**
     * 在bean执行初始化方法之前执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
