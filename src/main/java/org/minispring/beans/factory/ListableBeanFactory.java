package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory 是 Spring 框架中的一个核心接口，它是 BeanFactory 接口的子接口，
 * 用于查询Bean的接口，它支持查询Bean的定义、实例、名称和别名等一系列功能
 */
public interface ListableBeanFactory extends BeanFactory {


    //一句话总结：用于查询Bean的接口，它支持查询Bean的定义、实例、名称和别名等一系列功能


    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
