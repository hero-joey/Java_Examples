package com.hero.designpatten.command;

/**
 * @description: GotStartCommand
 * @date: 2021/3/26 9:53
 * @author: maccura
 * @version: 1.0
 */
public class GotStarCommand implements Command {

    public GotStarCommand(byte[] data) {
    }

    @Override
    public void execute() {
        System.out.println("Got start");
    }
}
