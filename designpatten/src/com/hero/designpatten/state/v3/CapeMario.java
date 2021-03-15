package com.hero.designpatten.state.v3;

/**
 * @description: CapeMario
 * @date: 2021/3/15 10:52
 * @author: maccura
 * @version: 1.0
 */
public class CapeMario implements IMario {

    private  MarioStateMachine stateMachine;

    public CapeMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }


    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
