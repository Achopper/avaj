package edu.school21.avaj.simulator.application;

import edu.school21.avaj.simulator.aircraft.Coordinates;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;
import edu.school21.avaj.simulator.tower.Tower;
import edu.school21.avaj.simulator.tower.WeatherProvider;

import java.io.IOException;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.get_instance().getCurrentWeather(coordinates);
    }

    void changeWeather() throws RegistrationFailException {
        conditionChange();
    }

    public void getMsg(String message){
        try {
            Main.writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
