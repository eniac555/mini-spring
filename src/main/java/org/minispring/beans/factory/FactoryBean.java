package org.minispring.beans.factory;


/**
 * FactoryBean主要用来定制化Bean的创建逻辑
 * @param <T>
 * 当我们实例化一个Bean的逻辑很复杂的时候，使用FactoryBean是很必要的，这样可以规避我们去使用冗长的XML配置
 */

public interface FactoryBean<T> {

    //一句话总结：定制化Bean的创建逻辑

    T getObject() throws Exception;

    boolean isSingleton();
}
