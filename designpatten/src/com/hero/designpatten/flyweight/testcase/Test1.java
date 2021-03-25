package com.hero.designpatten.flyweight.testcase;

/**
 * @description: Test1
 * @date: 2021/3/25 10:22
 * @author: maccura
 * @version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
    }
}
