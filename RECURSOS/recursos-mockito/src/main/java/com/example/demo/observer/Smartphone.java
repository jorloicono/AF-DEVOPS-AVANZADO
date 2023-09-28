package com.example.demo.observer;

public class Smartphone implements WeatherObserver{
    @Override
    public void update(WeatherType type) {
        System.out.println("Smartphone has been notified of weather change: " + type);
    }
}
