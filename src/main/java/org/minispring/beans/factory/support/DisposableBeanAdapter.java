package org.minispring.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import org.minispring.beans.BeansException;
import org.minispring.beans.factory.DisposableBean;
import org.minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;


/**
 * 用于在Bean销毁时执行额外逻辑的适配器类，它实现了DisposableBean接口，
 * 并提供了执行销毁前和销毁后的逻辑的方法，支持Bean后置处理器和生命周期管理等一系列功能。
 * 在Spring中，DisposableBeanAdapter常用于扩展Bean的销毁逻辑，例如执行清理操作或释放资源等。
 */
public class DisposableBeanAdapter implements DisposableBean {

    //一句话总结：在Bean销毁时执行额外逻辑的适配器类，常用于扩展Bean的销毁逻辑


    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        //避免同时继承自DisposableBean，且自定义方法与DisposableBean方法同名，销毁方法执行两次的情况
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            //执行自定义方法
            Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if (destroyMethod == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
