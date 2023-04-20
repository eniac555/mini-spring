package org.minispring.bean;

import org.junit.Test;
import org.minispring.beans.factory.config.BeanDefinition;
import org.minispring.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registryBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}

class HelloService {
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
