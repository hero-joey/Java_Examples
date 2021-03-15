package com.hero.designpatten.state.v4;

import com.hero.designpatten.state.v4.IMario;
import com.hero.designpatten.state.v4.SmallMario;

/**
 * @description: MarioStateMachine
 * @date: 2021/3/15 8:57
 * @author: maccura
 * @version: 1.0
 */
public class MarioStateMachine {
    private int score;
    private IMario currentState; // 不再使用枚举来表示状态

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
