package com.hero.context.event;

/**
 * @description: SnowWeatherEvent
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class SnowWeatherEvent extends WeatherEvent {
    @Override
    String getWhether() {
        return "Snow";
    }
}
