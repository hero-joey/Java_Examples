package com.hero.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description: ServerStartReporter
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
@Component
@Order(2)
public class ServerStartReporter implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println("应用启动的时间是: " + LocalDateTime.now().toString());
    }
}
