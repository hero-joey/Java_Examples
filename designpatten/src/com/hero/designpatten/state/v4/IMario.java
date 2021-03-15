package com.hero.designpatten.state.v4;

/**
 * @description: IMario
 * @date: 2021/3/15 11:07
 * @author: maccura
 * @version: 1.0
 */
public interface IMario {
    State getName();
    void obtainMushRoom(MarioStateMachine stateMachine);
    void obtainCape(MarioStateMachine stateMachine);
    void obtainFireFlower(MarioStateMachine stateMachine);
    void meetMonster(MarioStateMachine stateMachine);
}
