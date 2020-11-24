package com.hero.context.event;

/**
 * @description: EventMulticaster
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public interface EventMulticaster {
    void multicastEvent(WeatherEvent weatherEvent);
    void addListener(WeatherListener weatherListener);
    void removeListener(WeatherListener weatherListener);
}
