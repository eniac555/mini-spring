package org.minispring.beans.factory;

/**
 * 销毁bean的接口
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
