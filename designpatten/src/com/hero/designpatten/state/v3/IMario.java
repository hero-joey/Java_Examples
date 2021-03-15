package com.hero.designpatten.state.v3;

/**
 * @description: IMario
 * @date: 2021/3/15 9:56
 * @author: maccura
 * @version: 1.0
 */
public interface IMario {
    State getName();
    //以下是定义的事件
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}
