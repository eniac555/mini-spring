package org.minispring.beans.factory.config;

import org.minispring.beans.factory.HierarchicalBeanFactory;
import org.minispring.core.convert.ConversionService;
import org.minispring.utils.StringValueResolver;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
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
