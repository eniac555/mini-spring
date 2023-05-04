package org.minispring.beans.factory.support.impl;

import org.minispring.beans.BeansException;
import org.minispring.beans.factory.DisposableBean;
import org.minispring.beans.factory.ObjectFactory;
import org.minispring.beans.factory.config.SingletonBeanRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * SingletonBeanRegistry接口的实现类
 * DefaultSingletonBeanRegistry是Spring框架中的一个实现了SingletonBeanRegistry接口的默认实现类，
 * 它提供了一些默认的单例Bean对象的注册和获取方法，并对注册的Bean对象进行缓存，以提高获取Bean对象的效率。
 * <p>
 * 具体来说，DefaultSingletonBeanRegistry维护了三个Map对象，分别用于存储
 * Bean名称到Bean对象实例的映射、Bean名称到ObjectFactory实例的映射以及所有已注册的Bean名称的集合。
 * 这三个Map对象构成了Spring框架中常说的“三级缓存”。
 * <p>
 * 在使用DefaultSingletonBeanRegistry注册单例Bean对象时，它会先检查一级缓存，
 * 即存储Bean名称到Bean对象实例的Map对象，如果能够找到对应的Bean对象，则直接返回该Bean对象；
 * 否则，它会检查二级缓存，即存储Bean名称到ObjectFactory实例的Map对象，
 * 如果能够找到对应的ObjectFactory实例，则调用该实例的getObject()方法创建一个新的Bean对象，
 * 并将其保存到一级缓存中，然后返回该Bean对象；如果仍然找不到对应的Bean对象，
 * 则检查三级缓存，即存储所有已注册的Bean名称的集合，如果能够找到对应的Bean名称，
 * 则创建一个新的ObjectFactory实例，并将其保存到二级缓存中，然后调用该实例的getObject()方法创建一个新的Bean对象，
 * 并将其保存到一级缓存中，最后返回该Bean对象。
 * <p>
 * 除了提供单例Bean对象的注册和获取方法之外，DefaultSingletonBeanRegistry还提供了一些用于
 * 管理单例Bean对象的方法，例如：
 * <p>
 * containsSingleton(String beanName)：判断指定名称的Bean对象是否已经注册为单例对象；
 * getSingletonNames()：获取所有已注册的单例Bean对象的名称；
 * getSingletonCount()：获取已注册的单例Bean对象的数量；
 * registerDisposableBean(String beanName, DisposableBean bean)：注册一个DisposableBean对象，用于在Bean对象销毁时进行回调；
 * destroySingletons()：销毁所有已注册的单例Bean对象。
 * 总之，DefaultSingletonBeanRegistry是Spring框架中用于管理单例Bean对象的一个默认实现类，
 * 它提供了一些常用的方法和缓存机制，可以方便地注册、获取、销毁单例Bean对象。
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    //一句话总结：提供了一些默认的单例Bean对象的注册和获取方法，并对注册的Bean对象进行三级缓存

    //一级缓存
    private Map<String, Object> singletonObjects = new HashMap<>();
    //二级缓存
    private Map<String, Object> earlySingletonObjects = new HashMap<>();
    //三级缓存
    private Map<String, ObjectFactory<?>> singletonFactories =
            new HashMap<String, ObjectFactory<?>>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    //在实际使用中，要获取一个bean，先从一级缓存一直查找到三级缓存，
    // 缓存bean的时候是从三级到一级的顺序保存，并且缓存bean的过程中，
    // 三个缓存都是互斥的，只会保持bean在一个缓存中，而且，最终都会在一级缓存中。
    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                ObjectFactory<?> objectFactory = singletonFactories.get(beanName);
                if (objectFactory != null) {
                    singletonObject = objectFactory.getObject();
                    //从三级缓存放入到二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        singletonFactories.put(beanName, singletonFactory);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    //销毁单例
    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }


}
