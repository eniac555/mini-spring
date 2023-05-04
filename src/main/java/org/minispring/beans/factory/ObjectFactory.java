package org.minispring.beans.factory;

import org.minispring.beans.BeansException;

/**
 * ObjectFactory是Spring框架中定义的一个泛型接口，用于创建和获取指定类型的对象实例。
 * 它提供了一个getObject()方法，该方法用于返回一个指定类型的对象实例。
 * 在Spring框架中，ObjectFactory通常被用于创建单例Bean的代理对象，以延迟单例Bean的初始化。
 * <p>
 * 在实际使用中，可以通过ObjectFactory来获取指定类型的Bean对象实例。
 * 对于单例Bean，ObjectFactory通常会返回一个代理对象，以保证单例Bean的延迟初始化和懒加载特性。
 * 对于多例Bean，ObjectFactory则会返回一个新的Bean对象实例
 *
 * @param <T>
 */
public interface ObjectFactory<T> {

    //一句话总结：创建和获取指定类型的对象实例

    T getObject() throws BeansException;
}
