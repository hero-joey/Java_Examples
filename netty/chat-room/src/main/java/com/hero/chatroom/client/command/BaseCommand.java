package com.hero.chatroom.client.command;

import java.util.Scanner;

/**
 * @description: BaseCommand
 * @date: 2021/1/18
 * @author: bear
 * @version: 1.0
 */
public interface BaseCommand {
    void parse(Scanner scanner);
    String shortcut();
    String help();
}
