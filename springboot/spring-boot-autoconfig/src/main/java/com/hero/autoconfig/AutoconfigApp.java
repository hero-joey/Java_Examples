package com.hero.autoconfig;

import com.google.gson.Gson;
import com.hero.core.bean.Role;
import com.hero.core.bean.RoleConfiguration;
import com.hero.core.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @description: MyBatisApp
 * EnableAutoConfiguration搜索所有classpath:/META-INF/spring.factoriespe配置文件，然后
 * 将其中org.springframework.boot.autoconfigure.EnableAutoConfiguration key对应的配置项加载到spring容器中
 *
 *ImportSelector接口返回值会被纳入到spring容器中管理
 * SpringFactoryLoader可以从classpath:/META-INF/spring.factoriespe
 *spring.boot.enableautoconfiguration=false不启用配置，默认启用
 * EnableAutoConfiguration可以进行配置类的排除,类名或者类路径
 * @date: 2020/9/9 16:05
 * @author: maccura
 * @version: 1.0
 */

@Configuration
@EnableAutoConfiguration()
@ComponentScan()
public class AutoconfigApp {

    @Bean(name = "gson2")
    Gson createGson() {
        return new Gson();
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AutoconfigApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run();
        System.out.println(configurableApplicationContext.getBean(Runnable.class));
        System.out.println(configurableApplicationContext.getBean(User.class));
        System.out.println(configurableApplicationContext.getBean(Role.class));
        System.out.println(configurableApplicationContext.getBean("gson2"));

        //System.out.println(configurableApplicationContext.getBeansOfType(Runnable.class));
        configurableApplicationContext.close();
    }

}
