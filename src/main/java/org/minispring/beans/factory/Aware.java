package org.minispring.beans.factory;

/**
 * Aware接口的主要功能是在Bean实例化后，将特定的资源注入到Bean中，从而使得Bean可以使用这些资源。
 * <p>
 * Spring框架提供了多个Aware接口，例如：
 * <p>
 * BeanFactoryAware：获取BeanFactory实例。
 * <p>
 * ApplicationContextAware：获取ApplicationContext实例。
 * <p>
 * BeanNameAware：获取Bean的名称。
 * <p>
 * ResourceLoaderAware：获取ResourceLoader实例。
 * <p>
 * ServletContextAware：获取ServletContext实例。
 */
public interface Aware {

    //一句话总结：在Bean实例化后，将特定的资源注入到Bean中，从而使得Bean可以使用这些资源，
    // 如BeanFactoryAware：获取BeanFactory实例

}
