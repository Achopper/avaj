package edu.school21.avaj.simulator.tower;

import edu.school21.avaj.simulator.aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider      _instance;
    private static final String[]        WEATHER = {"RAIN","FOG","SUN","SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider get_instance() {
        if (_instance != null)
            return _instance;
        else
            return new WeatherProvider();
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random random = new Random();
        return WEATHER[random.nextInt(4)];
    }

}
