package org.minispring.beans.factory.config;

/**
 * 单例注册表接口
 * SingletonBeanRegistry是Spring框架中定义的一个接口，它提供了两个方法用于管理单例Bean对象的注册和获取。
 * 这两个方法分别是：
 * <p>
 * Object getSingleton(String beanName)：根据给定的bean名称获取对应的单例Bean对象，
 * 如果该Bean对象尚未被创建，则返回null。
 * <p>
 * void addSingleton(String beanName, Object singletonObject)：
 * 向单例Bean缓存中注册一个新的Bean对象。如果缓存中已经存在同名的Bean对象，则会抛出异常
 */
public interface SingletonBeanRegistry {

    //一句话总结：管理单例Bean对象的注册和获取的接口

    //获取bean
    Object getSingleton(String beanName);

    //添加bean
    void addSingleton(String beanName, Object singletonObject);
}
