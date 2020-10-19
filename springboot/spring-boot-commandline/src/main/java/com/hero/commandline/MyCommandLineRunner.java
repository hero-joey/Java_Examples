package com.hero.commandline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description: MyCommandLineRunner
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("应用已经成功启动: " + Arrays.asList(args));
    }
}
