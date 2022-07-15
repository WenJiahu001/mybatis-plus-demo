package com.wjh.demo.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 文家虎
 * @Package com.wjh.demo.utils
 * @date 2021/6/15 15:54
 */
public class ConvertQueryWrapperUtils {


    public static <T> QueryWrapper toWrapper(T t) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        Class clazz = t.getClass();
        List<Field> allFields = new ArrayList<>(20);

        // 获取当前对象的所有属性字段
        // clazz.getFields()：获取public修饰的字段
        // clazz.getDeclaredFields()： 获取所有的字段包括private修饰的字段
        allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        // 获取所有父类的字段， 父类中的字段需要逐级获取
        Class clazzSuper = clazz.getSuperclass();

        // 如果父类不是object，表明其继承的有其他类。 逐级获取所有父类的字段
        while (clazzSuper != Object.class) {
            allFields.addAll(Arrays.asList(clazzSuper.getDeclaredFields()));
            clazzSuper = clazzSuper.getSuperclass();
        }

        allFields.stream().forEach(field -> {

            // 设置字段可访问， 否则无法访问private修饰的变量值
            field.setAccessible(true);
            try {
                // 获取字段名称
                String fieldName = field.getName();

                // 获取指定对象的当前字段的值
                Object fieldVal = field.get(t);

                if (null != field) {
                    //时间要单独处理
                    if (fieldName.indexOf("Time") != -1) {
                        if (fieldName.indexOf("Begin") != -1) {
                            //如果是开始时间
                            fieldName = fieldName.replaceAll("Begin", "");
                            queryWrapper.ge(fieldName, fieldVal);
                        } else if (fieldName.indexOf("End") != -1) {
                            //如果是结束时间
                            fieldName = fieldName.replaceAll("End", "");
                            queryWrapper.lt(fieldName, fieldVal);
                        }
                    } else {
                        queryWrapper.eq(fieldName, fieldVal);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return null;
    }
}
