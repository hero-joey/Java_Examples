package com.hero.designpatten.iterator.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: FailFastDemo
 * @date: 2021/3/16 15:21
 * @author: maccura
 * @version: 1.0
 */
public class FailFastDemo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            integers.remove(0);
            System.out.println("delete success");
        }
    }
}
