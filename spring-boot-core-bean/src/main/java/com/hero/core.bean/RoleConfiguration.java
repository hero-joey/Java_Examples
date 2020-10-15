package com.hero.core.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: RoleConfiguration
 * @date: 2020/10/15
 * @author: bear
 * @version: 1.0
 */
@Configuration
public class RoleConfiguration {
    @Bean
    public Role createRole() {
        return new Role();
    }
}
