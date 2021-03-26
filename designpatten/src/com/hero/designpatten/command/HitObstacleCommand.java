package com.hero.designpatten.command;

/**
 * @description: HitObstacleCommand
 * @date: 2021/3/26 9:55
 * @author: maccura
 * @version: 1.0
 */
public class HitObstacleCommand implements Command {

    public HitObstacleCommand(byte[] data) {
    }

    @Override
    public void execute() {
        System.out.println("Hit Obstacle");
    }
}
