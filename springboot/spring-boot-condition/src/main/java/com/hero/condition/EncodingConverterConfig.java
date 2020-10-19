package com.hero.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Conditional基于条件的自动装配，一般配合condition接口一起使用,只有接口(一个或者多个)都返回true才装配，否则不装配
 * 既可以用于方法上，也可以用于类上面，用于类上，则对该类的所有方法起作用
 * Conditional
 * @description: EncodingConverterConfig
 * @date: 2020/10/13
 * @author: bear
 * @version: 1.0
 */
@Configuration
@Conditional(GBKCondition.class)
public class EncodingConverterConfig {

    @Bean
    //@Conditional(GBKCondition.class)
    //Conditional既可以用于方法，也可以用于类上面
    EncodingConverter getGBKEncodingConverter() {
        return new GBKEncodingConverter();
    }

    @Bean
    //@Conditional(UTF8Condition.class)
    EncodingConverter getUTF8EncodingConverter() {
        return new UTF8EncodingConverter();
    }


}
