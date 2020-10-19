package com.hero.scan;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: ScanApp
 * @date: 2020/10/17
 * @author: bearT
 * @version: 1.0
 */

/**
 * SpringBootApplication默认扫描当前包路径是当前包及子包下面的所有类,可以通过指定scanBasePackages设置
 * exclude  exclude = GsonAutoConfiguration.class
 * exclude  excludeName = "org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration"
 *
 */
@SpringBootApplication(scanBasePackages={"com.hero"})
public class ScanApp {
    @Value("${server.host:localhost}")
    private String serverHost;

    public String getServerHost() {
        return serverHost;
    }

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ScanApp.class);

        //给配置项指定默认值
        Map<String, Object> map = new HashMap<>();
        map.put("server.host", "192.168.10.105");
        springApplication.setDefaultProperties(map);

        //关闭banner,
        // 自定义classpath:下面放置banner.txt,或者banner.location=XXXX指定文件路径
        springApplication.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        System.out.println(configurableApplicationContext.getBean(Runnable.class));
        System.out.println(configurableApplicationContext.getBean(Gson.class));

        //defaultProperties优先
        System.out.println(configurableApplicationContext.getEnvironment().getProperty("server.host", "127.0.0.1"));
        System.out.println(configurableApplicationContext.getBean(ScanApp.class).getServerHost());
        configurableApplicationContext.close();

    }
}
