package com.hero.designpatten.state.v4;

import com.hero.designpatten.state.v4.IMario;
import com.hero.designpatten.state.v4.MarioStateMachine;
import com.hero.designpatten.state.v4.State;

/**
 * @description: CapeMario
 * @date: 2021/3/15 10:52
 * @author: maccura
 * @version: 1.0
 */
public class CapeMario implements IMario {

    private static final CapeMario instance = new CapeMario();

    public CapeMario() {

    }

    public static CapeMario getInstance() {
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
