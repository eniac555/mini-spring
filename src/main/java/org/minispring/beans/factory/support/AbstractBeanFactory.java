package org.minispring.beans.factory.support;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.FactoryBean;
import org.minispring.beans.factory.config.BeanDefinition;
import org.minispring.beans.factory.config.BeanPostProcessor;
import org.minispring.beans.factory.config.ConfigurableBeanFactory;
import org.minispring.beans.factory.support.impl.DefaultSingletonBeanRegistry;
import org.minispring.core.convert.ConversionService;
import org.minispring.utils.StringValueResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于创建和管理Bean实例的抽象类，它提供了一些通用的BeanFactory功能和抽象方法
 * 统一的Bean定义管理
 * 统一的Bean实例管理
 * 统一的Bean后置处理器管理
 * 统一的Bean初始化管理
 * 统一的Bean销毁管理
 * 提供Bean的作用域
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory {

    //一句话总结：创建和管理Bean实例的抽象类，提供了一些通用的BeanFactory功能和抽象方法

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    private final List<StringValueResolver> embeddedValueResolvers = new ArrayList<StringValueResolver>();

    private ConversionService conversionService;


    @Override
    public Object getBean(String name) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            //如果是FactoryBean，从FactoryBean#getObject中创建bean
            return getObjectForBeanInstance(sharedInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition);
        return getObjectForBeanInstance(bean, name);
    }

    /**
     * 如果是FactoryBean，从FactoryBean#getObject中创建bean
     *
     * @param beanInstance
     * @param beanName
     * @return
     */
    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        Object object = beanInstance;
        if (beanInstance instanceof FactoryBean) {
            FactoryBean factoryBean = (FactoryBean) beanInstance;
            try {
                if (factoryBean.isSingleton()) {
                    //singleton作用域bean，从缓存中获取
                    object = this.factoryBeanObjectCache.get(beanName);
                    if (object == null) {
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName, object);
                    }
                } else {
                    //prototype作用域bean，新创建bean
                    object = factoryBean.getObject();
                }
            } catch (Exception ex) {
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", ex);
            }
        }
        return object;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return ((T) getBean(name));
    }

    @Override
    public boolean containsBean(String name) {
        return containsBeanDefinition(name);
    }

    protected abstract boolean containsBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
        this.embeddedValueResolvers.add(valueResolver);
    }

    public String resolveEmbeddedValue(String value) {
        String result = value;
        for (StringValueResolver resolver : this.embeddedValueResolvers) {
            result = resolver.resolveStringValue(result);
        }
        return result;
    }

    @Override
    public ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
}
