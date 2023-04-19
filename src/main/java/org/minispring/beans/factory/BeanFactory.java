package org.minispring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 最简单的bean容器
 * 内部包含一个map用于存储bean
 * 只有注册bean和获取bean两个方法
 */
public class BeanFactory {

    //定义存储bean的map
    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }

}
