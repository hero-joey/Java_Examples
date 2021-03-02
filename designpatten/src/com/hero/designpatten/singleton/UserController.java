package com.hero.designpatten.singleton;

import java.io.IOException;

/**
 * @description: UserController
 * @date: 2021/3/2 11:22
 * @author: maccura
 * @version: 1.0
 */
public class UserController {


    public UserController() throws IOException {
    }

    public void login(String username, String password) throws IOException {
        Logger.getInstance().log(username + "login!");
    }
}
