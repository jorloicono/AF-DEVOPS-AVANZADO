package com.example.seccion3;

import com.example.demo.observer.Weather;
import com.example.demo.observer.WeatherObserver;
import com.example.demo.observer.WeatherType;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class AArgumentCaptorTest {

    @Mock
    private WeatherObserver weatherObserver; // mock

    @InjectMocks
    private Weather weather; // clase a testear

    @Test
    void test1() {
        weather.addObserver(weatherObserver);

        weather.changeWeather(WeatherType.RAINY);

        ArgumentCaptor<WeatherType> argCaptor = ArgumentCaptor.forClass(WeatherType.class);
        verify(weatherObserver).update(argCaptor.capture());
        assertEquals(WeatherType.CLOUDY, argCaptor.getValue());
    }

    @Test
    void test2() {
        weather.addObserver(weatherObserver);

        weather.changeWeather(WeatherType.RAINY);
        weather.changeWeather(WeatherType.SUNNY);

        ArgumentCaptor<WeatherType> argCaptor = ArgumentCaptor.forClass(WeatherType.class);
        verify(weatherObserver, times(2)).update(argCaptor.capture());

        List<WeatherType> types = argCaptor.getAllValues();
        assertEquals(WeatherType.RAINY, types.get(0));
        assertEquals(WeatherType.SUNNY, types.get(1));
    }

}
