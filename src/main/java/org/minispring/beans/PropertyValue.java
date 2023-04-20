package org.minispring.beans;

/**
 * 封装Bean对象属性的值
 * <p>
 * PropertyValue对象通常会被用作BeanDefinition中的属性列表（PropertyValues）的元素，
 * 用于描述Bean对象的属性配置信息。
 * <p>
 * 在Spring框架中，PropertyValue对象通常会被封装为一个PropertyValues对象，
 * 用于描述Bean对象的属性配置信息。在Bean对象的创建和初始化过程中，
 * Spring框架会自动解析PropertyValues对象，并将其中的属性值注入到Bean对象中，以完成Bean对象的属性赋值。
 */
public class PropertyValue {

    //一句话总结：封装Bean对象属性的值

    //被final修饰的成员变量表示该变量的值在初始化之后就不能再被修改。
    private final String name;
    private final Object value;

    //构造方法
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
