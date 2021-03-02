package com.hero.designpatten.logger;

import java.io.IOException;

/**
 * @description: UserController
 * @date: 2021/3/2 11:22
 * @author: maccura
 * @version: 1.0
 */
public class UserController {
    private Logger logger = new Logger();

    public UserController() throws IOException {
    }

    public void login(String username, String password) throws IOException {
        logger.log("username" + "login!");
    }
}
