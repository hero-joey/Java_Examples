package com.hero.commandline;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description: MyApplicationRunner
 * @date: 2020/10/19
 * @author: bear
 * @version: 1.0
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("app args: " + Arrays.asList(args.getSourceArgs()));
    }
}
