package org.spring.bean;

import org.junit.Test;
import org.spring.beans.BeanFactory;

public class SimpleBeanFactoryTest {

    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        System.out.println(helloService==null);//false
        assert helloService != null;//防止下面报空指针异常
        System.out.println(helloService.hello());
    }

    private class HelloService {
        public String hello() {
            return "hello";
        }
    }
}
