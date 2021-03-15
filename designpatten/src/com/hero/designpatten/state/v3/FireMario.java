package com.hero.designpatten.state.v3;

/**
 * @description: FireMario
 * @date: 2021/3/15 10:53
 * @author: maccura
 * @version: 1.0
 */
public class FireMario implements IMario {

    private  MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
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
