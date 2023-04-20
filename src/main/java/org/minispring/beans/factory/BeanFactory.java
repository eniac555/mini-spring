package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory 是 Spring 框架中最基础的接口之一，
 * 用于实现控制反转（IoC）和依赖注入（DI）的核心功能。
 * 它是一个工厂模式接口，用于创建和管理Bean对象，负责Bean对象的实例化、配置、装配和生命周期的管理。
 */
public interface BeanFactory {

    /**
     * 获取bean
     * @param beanName
     * @return
     * @throws BeansException bean不存在抛出异常
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 根据名称和类型获取bean
     * @param beanName
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;

    /**
     * 根据类型获取bean
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    //根据名字判断是否包含bean
    boolean containsBean(String name);
}
