package com.hero.designpatten.pipeline.versionOne;

/**
 * @description: Handler
 * @date: 2021/3/8 13:26
 * @author: maccura
 * @version: 1.0
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();
}
