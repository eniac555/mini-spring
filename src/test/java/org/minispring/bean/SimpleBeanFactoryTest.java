package org.minispring.bean;

import org.junit.Test;
import org.minispring.beans.factory.BeanFactory;

public class SimpleBeanFactoryTest {

    /**
     * 测试最简单的bean容器
     */
    @Test
    public void testGetBean() {
/*        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        System.out.println(helloService==null);//false
        assert helloService != null;//防止下面报空指针异常
        System.out.println(helloService.hello());*/
    }

    private class HelloService {
        public String hello() {
            return "hello";
        }
    }
}
