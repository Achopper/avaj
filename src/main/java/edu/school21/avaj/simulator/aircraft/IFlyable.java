package edu.school21.avaj.simulator.aircraft;

import com.sun.deploy.association.RegisterFailedException;
import edu.school21.avaj.simulator.tower.weatherTower.WeatherTower;

public interface IFlyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower) throws RegisterFailedException;
}
