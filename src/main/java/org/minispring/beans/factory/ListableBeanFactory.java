package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory 是 Spring 框架中的一个核心接口，它是 BeanFactory 接口的子接口，
 * 提供了一些列的方法用于检索 Bean 定义及其相关信息，使得开发者可以更加方便地获取应用程序中的所有 Bean，
 * 以及对这些 Bean 进行操作。
 */
public interface ListableBeanFactory extends BeanFactory {


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
