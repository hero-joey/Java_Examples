package com.hero.designpatten.state.v2;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.security.Provider;

import static com.hero.designpatten.state.v2.State.*;

/**
 * @description: MarioStateMachine
 * @date: 2021/3/15 8:57
 * @author: maccura
 * @version: 1.0
 */
public class MarioStateMachine {
    private int score;
    private State currentState;

    private static final State[][] transitionTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE_FLOWER);
    }

    public void meetMonster() {
        executeEvent(Event.MEET_MONSTER);
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
