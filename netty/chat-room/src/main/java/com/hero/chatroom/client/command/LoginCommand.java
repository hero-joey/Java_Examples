package com.hero.chatroom.client.command;

import java.util.Scanner;

/**
 * @description: LoginCommand
 * @date: 2021/1/19
 * @author: bear
 * @version: 1.0
 */
public class LoginCommand implements BaseCommand{

    private String userName;
    private String password;

    @Override
    public void parse(Scanner scanner) {
        System.out.println("请输入用户信息(id:password)  ");

        while (true) {
            String input = scanner.next();
            String[] userInfo = input.split(":");
            if (userInfo.length != 2) {
                System.out.println("请按照格式输入(id:password):");
            } else {
                userName = userInfo[0];
                password = userInfo[1];;
            }
        }
    }

    @Override
    public String shortcut() {
        return "L";
    }

    @Override
    public String help() {
        return "Login";
    }
}
