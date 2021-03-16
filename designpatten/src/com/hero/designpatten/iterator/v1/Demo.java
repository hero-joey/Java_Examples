package com.hero.designpatten.iterator.v1;

import java.util.ArrayList;

/**
 * @description: Demo
 * @date: 2021/3/16 9:18
 * @author: maccura
 * @version: 1.0
 */
public class Demo {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");
        Iterator<String> iterator = new ArrayIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
