package com.hero.importer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;

/**
 * @description: MyBatisApp
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */

@ComponentScan
//@Import(MyImportSelector.class)
//
//@EnableLog(name = "myspringboot")
@EnableEcho(packages = {"com.hero.importer.bean", "com.hero.importer.bean2"})
public class ImporterApp {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ImporterApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        //System.out.println(configurableApplicationContext.getBean(User.class));
        //System.out.println(configurableApplicationContext.getBean(Role.class));
        //System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }

}
