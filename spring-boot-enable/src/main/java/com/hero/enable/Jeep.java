package com.hero.enable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description: Jeep
 * @date: 2020/10/14
 * @author: bear
 * @version: 1.0
 */
@Component
public class Jeep implements Runnable {

    @Async
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Jeep is running " + i);
                Thread.sleep(1000);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
