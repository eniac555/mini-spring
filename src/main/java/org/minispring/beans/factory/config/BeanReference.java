package org.minispring.beans.factory.config;

/**
 * 一个bean对另一个bean的引用
 */
public class BeanReference {

    //一句话总结：用于表示Bean依赖关系的类，它保存了一个Bean的引用，用于描述另一个Bean依赖该Bean的情况。

    private final String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
