package com.hero.designpatten.adaptor.classadaptor;

/**
 * @description: Adaptor
 * @date: 2021/3/19 16:45
 * @author: maccura
 * @version: 1.0
 */
public class Adaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        System.out.println("f1");
        super.fa();
    }

    @Override
    public void f2() {
        System.out.println("f2");
    }

    // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}
