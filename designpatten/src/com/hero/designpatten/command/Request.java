package com.hero.designpatten.command;

/**
 * @description: Request
 * @date: 2021/3/26 9:58
 * @author: maccura
 * @version: 1.0
 */
public class Request {
    public Event getEvent() {
        return Event.NONE;
    }

    public byte[] getData() {
        return new byte[10];
    }
}
