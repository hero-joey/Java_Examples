package com.hero.designpatten.state.v4;

import com.hero.designpatten.state.v4.IMario;
import com.hero.designpatten.state.v4.MarioStateMachine;
import com.hero.designpatten.state.v4.State;

/**
 * @description: FireMario
 * @date: 2021/3/15 10:53
 * @author: maccura
 * @version: 1.0
 */
public class FireMario implements IMario {

    private static final FireMario instance = new FireMario();

    public FireMario() {

    }

    public static FireMario getInstance() {
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
