package org.minispring.beans.factory.config;

import org.minispring.beans.factory.HierarchicalBeanFactory;
import org.minispring.core.convert.ConversionService;
import org.minispring.utils.StringValueResolver;


/**
 * 用于配置Bean工厂的接口，它提供了设置Bean的类加载器、表达式解析器、属性编辑器、作用域和自动装配规则
 * 等一系列配置功能的方法，可以帮助开发人员更加灵活地管理和配置Bean。
 * 它主要用于AbstractApplicationContext等应用上下文实现类中，协助应用上下文实现Bean的配置和管理。
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    //一句话总结：用于配置Bean工厂的接口


    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例bean
     */
    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();
}
