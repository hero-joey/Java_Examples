package com.hero.context.event;

/**
 * @description: SnowWeatherListener
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class SnowWeatherListener implements WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent weatherEvent) {
        if (weatherEvent instanceof SnowWeatherEvent) {
            System.out.println("Snow event");
        }
    }
}
