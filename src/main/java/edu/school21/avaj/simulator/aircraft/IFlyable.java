package edu.school21.avaj.simulator.aircraft;

import edu.school21.avaj.simulator.application.WeatherTower;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

public interface IFlyable {
    void updateConditions() throws RegistrationFailException;
    void registerTower(WeatherTower weatherTower) throws RegistrationFailException;
}
