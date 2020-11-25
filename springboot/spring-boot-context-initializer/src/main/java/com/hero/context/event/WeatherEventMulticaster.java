package com.hero.context.event;

/**
 * @description: WeatherEventMulticaster
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class WeatherEventMulticaster extends AbstractEventMulticaster{
    @Override
    protected void stop() {
        System.out.println("end multicast weather");
    }

    @Override
    protected void start() {
        System.out.println("start multicast weather");
    }
}
