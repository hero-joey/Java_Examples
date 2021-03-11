package com.hero.designpatten.pipeline.versionThree;

import java.util.ArrayList;

/**
 * @description: HandlerChain
 * @date: 2021/3/8 14:25
 * @author: maccura
 * @version: 1.0
 */
public class HandlerChain {
    private ArrayList<Ihandler> handlers = new ArrayList<>();

    public void addHandler(Ihandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (Ihandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                break;
            }
        }
    }
}
