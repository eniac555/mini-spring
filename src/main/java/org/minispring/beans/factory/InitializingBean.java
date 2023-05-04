package org.minispring.beans.factory;


/**
 * 用于在Bean初始化后执行额外逻辑的接口。
 * 它定义了一个afterPropertiesSet()方法，用于在Bean属性设置完毕后执行额外逻辑。
 */
public interface InitializingBean {

    //一句话总结：用于在Bean初始化后执行额外逻辑的接口。
    void afterPropertiesSet() throws Exception;
}
