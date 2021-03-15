package com.hero.designpatten.state.v3;

/**
 * @description: State
 * @date: 2021/3/15 8:55
 * @author: maccura
 * @version: 1.0
 */
public enum State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;
    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
