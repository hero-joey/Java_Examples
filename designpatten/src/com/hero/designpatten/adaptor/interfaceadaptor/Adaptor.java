package com.hero.designpatten.adaptor.interfaceadaptor;

/**
 * @description: Adaptor
 * @date: 2021/3/19 16:45
 * @author: maccura
 * @version: 1.0
 */
public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        System.out.println("f1");
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
        System.out.println("f2");
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
