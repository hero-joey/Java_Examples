package com.hero.context.event;

/**
 * @description: RainWeatherListener
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public class RainWeatherListener implements WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent weatherEvent) {
        if (weatherEvent instanceof RainWeatherEvent) {
            System.out.println("Rain event");
        }
    }
}
