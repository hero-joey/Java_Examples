package com.hero.designpatten.command;

/**
 * @description: GotDiamondCommand
 * @date: 2021/3/26 9:52
 * @author: maccura
 * @version: 1.0
 */
public class GotDiamondCommand implements Command {

    public GotDiamondCommand(byte[] data) {
    }

    @Override
    public void execute() {
        System.out.println("Got Diamond");
    }
}
