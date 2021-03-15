package com.hero.designpatten.state.v4;

import com.hero.designpatten.state.v4.IMario;
import com.hero.designpatten.state.v4.MarioStateMachine;
import com.hero.designpatten.state.v4.State;

/**
 * @description: SmallMario
 * @date: 2021/3/15 9:58
 * @author: maccura
 * @version: 1.0
 */
public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();
    public SmallMario() {

    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
// do nothing...
    }
}
