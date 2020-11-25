package com.hero.parameterized;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Field[] fields = ParameterizedBean.class.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName() + " : " + field.getGenericType().getTypeName());
            System.out.println(field.getGenericType() instanceof ParameterizedType);

            if (field.getGenericType() instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                System.out.println("Raw type: " + parameterizedType.getRawType().getTypeName());
                System.out.println("Owner type:" + parameterizedType.getOwnerType());
                Type[] actualTypes = parameterizedType.getActualTypeArguments();
                for (Type type: actualTypes) {
                    System.out.println("typename: " + type.getTypeName());
                    System.out.println("type class name: " + type.getClass().getSimpleName());
                }


            }
        }
    }
}
