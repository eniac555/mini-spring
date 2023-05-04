package org.minispring.beans.factory;

/**
 * 销毁bean的接口
 * 用于在Bean销毁时执行额外逻辑的接口。它定义了一个destroy()方法，用于在Bean销毁时执行额外逻辑。
 */
public interface DisposableBean {

    //一句话总结：定义bean销毁时额外执行逻辑的接口
    void destroy() throws Exception;
}
