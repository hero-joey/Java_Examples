package com.hero.di;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class Demo
{
    public static void main( String[] args )
    {
        ClassLoader classLoader = Demo.class.getClassLoader();
        URL resource = classLoader.getResource("beans.xml");
        String path = resource.getPath();
        System.out.println(path);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();

    }
}
