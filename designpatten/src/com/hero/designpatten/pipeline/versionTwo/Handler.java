package com.hero.designpatten.pipeline.versionTwo;

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

    public void handle() {
        boolean handled = doHandle();
        //根据handled结果判断是否需要继续处理
        if (!handled && successor != null) {
            successor.handle();
        }
    }

    public abstract boolean doHandle();
}
