package com.hero.p2p;

import java.util.Random;

/**
 * @description: UserService
 * @date: 2021/3/11 9:31
 * @author: maccura
 * @version: 1.0
 */
public class UserService {
    public Long register(String username, String passsword) {
        Random random = new Random(System.currentTimeMillis());
        return random.nextLong();
    }
}
