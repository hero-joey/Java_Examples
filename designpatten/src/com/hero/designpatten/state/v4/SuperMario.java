package com.hero.designpatten.state.v4;

import com.hero.designpatten.state.v4.IMario;
import com.hero.designpatten.state.v4.MarioStateMachine;
import com.hero.designpatten.state.v4.State;

/**
 * @description: SuperMario
 * @date: 2021/3/15 10:44
 * @author: maccura
 * @version: 1.0
 */
public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();

    public SuperMario() {

    }

    public static SuperMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
