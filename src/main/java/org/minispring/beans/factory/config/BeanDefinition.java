package org.minispring.beans.factory.config;

import org.minispring.beans.PropertyValues;

import java.util.Objects;

/**
 * 用于定义bean信息的类，包括class类型、方法构造参数、bean属性、bean的scope等
 * 每个bean对应一个BeanDefinition的实例。
 * 此处是简化的BeanDefinition，仅包含bean的class类型。
 */
public class BeanDefinition {

    //一句话总结：描述一个Bean对象的定义信息


    public static String SCOPE_SINGLETON = "singleton";

    public static String SCOPE_PROTOTYPE = "prototype";

    private Class beanClass; //表示Bean的类型，通常是一个Java类

    private PropertyValues propertyValues;//表示Bean的属性值列表

    private String initMethodName;

    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;

    private boolean prototype = false;

    private boolean lazyInit = false;//表示Bean是否采用延迟初始化方式

    //创建一个BeanDefinition对象，并将传入的beanClass作为对象的类型信息进行初始化
    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    //同上
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    //设置scope
    public void setScope(String scope) {
        //将传入的scope赋值给对象的scope属性，即将Bean的作用域信息保存到对象中
        this.scope = scope;
        //判断Bean的作用域是否是singleton。如果是，则将对象的singleton属性设置为true，否则为false
        this.singleton = SCOPE_SINGLETON.equals(scope);
        //判断Bean的作用域是否是prototype。如果是，则将对象的prototype属性设置为true，否则为false
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    //基本的set和get，以及判断
    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public void setLazyInit(boolean b) {
        lazyInit = b;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    //重写的equals和hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeanDefinition that = (BeanDefinition) o;
        return beanClass.equals(that.beanClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanClass);
    }
}
