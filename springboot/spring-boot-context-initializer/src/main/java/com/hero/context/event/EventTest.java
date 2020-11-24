package com.hero.context.event;

/**
 * @description: EventTest
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class EventTest {
    public static void main(String[] args) {
        WeatherEventMulticaster weatherEventMulticaster = new WeatherEventMulticaster();
        SnowWeatherListener snowWeatherListener = new SnowWeatherListener();
        RainWeatherListener rainWeatherListener = new RainWeatherListener();
        weatherEventMulticaster.addListener(snowWeatherListener);
        weatherEventMulticaster.addListener(rainWeatherListener);

        SnowWeatherEvent snowWeatherEvent = new SnowWeatherEvent();
        weatherEventMulticaster.multicastEvent(snowWeatherEvent);

        RainWeatherEvent rainWeatherEvent = new RainWeatherEvent();
        weatherEventMulticaster.multicastEvent(rainWeatherEvent);

    }
}
