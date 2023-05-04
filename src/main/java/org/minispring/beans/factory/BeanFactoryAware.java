package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

/**
 * 用于获取Bean工厂实例的接口。它定义了一个setBeanFactory()方法，
 * 用于在Bean实例化后将BeanFactory实例注入到Bean中。
 * <p>
 * 通过实现BeanFactoryAware接口，
 * Bean可以获取到所在的Bean工厂实例，从而可以使用Bean工厂的各种功能，
 * 例如获取其他Bean实例或执行Bean工厂的其他操作
 */
public interface BeanFactoryAware extends Aware {


    //一句话总结：获取BeanFactory实例的接口，可用于在Bean实例化后将BeanFactory实例注入到Bean中

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
