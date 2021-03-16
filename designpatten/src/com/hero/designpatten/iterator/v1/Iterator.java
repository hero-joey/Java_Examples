package com.hero.designpatten.iterator.v1;

/**
 * @description: Iterator
 * @date: 2021/3/16 9:13
 * @author: maccura
 * @version: 1.0
 */
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
