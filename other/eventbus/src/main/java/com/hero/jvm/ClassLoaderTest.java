package com.hero.jvm;

/**
 * @description: ClassLoaderTest
 * @date: 2021/3/11 17:08
 * @author: maccura
 * @version: 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getClassLoader().toString());

        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().toString());

        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent().toString());
    }
}
