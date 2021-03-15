package com.hero.designpatten.state.v2;

/**
 * @description: Event
 * @date: 2021/3/15 9:44
 * @author: maccura
 * @version: 1.0
 */
public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE_FLOWER(2),
    MEET_MONSTER(3);
    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
