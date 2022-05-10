package edu.school21.avaj.simulator.tower.weatherTower;

import edu.school21.avaj.simulator.aircraft.Coordinates;
import edu.school21.avaj.simulator.tower.Tower;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.get_instance().getCurrentWeather(coordinates);
    }

    private void changeWeather(){
        conditionChange();
    }

    public void getMsg(String message){
        System.out.println(message);
        //TODO print in file
    }
}
