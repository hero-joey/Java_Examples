package com.hero.designpatten.pipeline.versionOne;

/**
 * @description: HandlerChain
 * @date: 2021/3/8 13:31
 * @author: maccura
 * @version: 1.0
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
