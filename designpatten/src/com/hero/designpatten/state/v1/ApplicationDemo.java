package com.hero.designpatten.state.v1;

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
        System.out.println("Score: " + marioStateMachine.getScore() + " , " + "State: " + marioStateMachine.getCurrentState().getValue());
    }
}
