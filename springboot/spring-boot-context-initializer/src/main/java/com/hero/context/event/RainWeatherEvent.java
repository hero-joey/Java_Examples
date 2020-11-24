package com.hero.context.event;

/**
 * @description: RainWeatherEvent
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class RainWeatherEvent extends WeatherEvent{
    @Override
    String getWhether() {
        return "Rain";
    }
}
