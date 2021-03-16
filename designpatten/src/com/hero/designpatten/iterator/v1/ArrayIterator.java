package com.hero.designpatten.iterator.v1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @description: ArrayIterator
 * @date: 2021/3/16 9:14
 * @author: maccura
 * @version: 1.0
 */
public class ArrayIterator<E> implements Iterator<E> {
    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor > arrayList.size()) {
            throw  new NoSuchElementException();
        }

        return arrayList.get(cursor);
    }
}
