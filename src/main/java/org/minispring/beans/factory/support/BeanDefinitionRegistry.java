package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 * 用于注册和获取BeanDefinition的方法
 * 管理Bean定义的接口，提供注册、获取、删除、判断是否存在和获取所有Bean定义名称等方法
 */
public interface BeanDefinitionRegistry {

    //一句话总结：管理Bean定义的接口，提供注册、获取、删除、判断是否存在和获取所有Bean定义名称等方法

    /**
     * 向注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据名称查找bean
     * @param beanName
     * @return
     * @throws BeansException 找不到抛出异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 查找是否包含指定名称的beanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回定义的所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
