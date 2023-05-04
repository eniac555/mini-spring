package org.minispring.core.convert;

/**
 * 用于类型转换的接口。它定义了一系列用于类型转换的方法，
 * 例如convert()、canConvert()、getConverter()等。
 * 通过实现ConversionService接口，可以自定义类型转换的逻辑，
 * 并将其注册到Spring容器中，从而实现自定义类型转换的功能。
 */
public interface ConversionService {

    //一句话总结：类型转换接口

    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
