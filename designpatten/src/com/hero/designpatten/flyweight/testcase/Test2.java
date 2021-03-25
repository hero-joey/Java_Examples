package com.hero.designpatten.flyweight.testcase;

/**
 * @description: Test2
 * @date: 2021/3/25 13:18
 * @author: maccura
 * @version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        String s1 = "小争哥";
        String s2 = "小争哥";
        String s3 = new String("小争哥");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
