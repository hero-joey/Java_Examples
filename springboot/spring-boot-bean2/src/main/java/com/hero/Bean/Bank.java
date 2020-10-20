package com.hero.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description: Bank
 * @date: 2020/10/8
 * @author: bear
 * @version: 1.0
 */

@Component
public class Bank {
    private ApplicationContext applicationContext;

    //spring4.3�����ԣ����Զ�ע�룬����Ҫautowireע��
    public Bank(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    void show() {
        System.out.println("Bank: " + applicationContext);
    }
}
