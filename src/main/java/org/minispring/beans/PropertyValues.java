package org.minispring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述Bean对象的属性配置信息
 * <p>
 * 每个PropertyValues对象通常包含多个PropertyValue对象，每个PropertyValue对象描述了一个属性的配置信息。
 */
public class PropertyValues {

    //一句话总结：描述Bean对象的属性配置信息，每个PropertyValues对象通常包含多个PropertyValue对象


    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    //更新bean的列表，如果原来没有，则加入列表
    public void addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue rawValue = this.propertyValueList.get(i);
            if (rawValue.getName().equals(propertyValue.getName())) {
                //如果名字一致，覆盖原有的属性值
                this.propertyValueList.set(i, propertyValue);
                return;
            }
        }
        this.propertyValueList.add(propertyValue);
    }


    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


    //根据类名字从bean列表中获取bean
    public PropertyValue getPropertyValue(String name) {
        for (int i = 0; i < this.propertyValueList.size(); i++) {
            PropertyValue propertyValue = this.propertyValueList.get(i);
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }
}
