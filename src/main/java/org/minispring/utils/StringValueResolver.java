package org.minispring.utils;


/**
 * 通常用于解析配置文件中的占位符或表达式，或者在运行时动态地解析字符串，例如动态生成SQL语句等。
 */
public interface StringValueResolver {

    //一句话总结：通常用于解析配置文件中的占位符或表达式，或者在运行时动态地解析字符串

    String resolveStringValue(String strVal);
}
