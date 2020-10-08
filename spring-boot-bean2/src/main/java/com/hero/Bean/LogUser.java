package com.hero.Bean;

/**
 * @description: LogUser
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */
public class LogUser extends User {
    @Override
    public void show() {
        System.out.println("log start...");
        super.show();
        System.out.println("log end...");
    }
}
