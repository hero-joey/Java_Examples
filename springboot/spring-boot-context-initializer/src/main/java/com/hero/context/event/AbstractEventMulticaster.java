package com.hero.context.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @description: AbstractEventMulticaster
 * @date: 2020/11/24
 * @author: bear
 * @version: 1.0
 */
public abstract class AbstractEventMulticaster implements EventMulticaster {
    private final List<WeatherListener> weatherListeners = new ArrayList<>();

    @Override
    public void addListener(WeatherListener weatherListener) {
        weatherListeners.add(weatherListener);
    }

    protected abstract void stop();

    protected abstract void start();

    @Override
    public void removeListener(WeatherListener weatherListener) {
        weatherListeners.remove(weatherListener);
    }

    @Override
    public void multicastEvent(WeatherEvent weatherEvent) {
        start();
        weatherListeners.forEach(weatherListener -> weatherListener.onWeatherEvent(weatherEvent));
        stop();
    }
}
