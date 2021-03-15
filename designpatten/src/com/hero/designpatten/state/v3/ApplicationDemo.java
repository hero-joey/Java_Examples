package com.hero.designpatten.state.v3;

/**
 * @description: ApplicationDemo
 * @date: 2021/3/15 9:01
 * @author: maccura
 * @version: 1.0
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainMushRoom();
        marioStateMachine.obtainFireFlower();
    }
}
