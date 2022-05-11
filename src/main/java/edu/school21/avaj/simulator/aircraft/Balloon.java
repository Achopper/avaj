package edu.school21.avaj.simulator.aircraft;

import edu.school21.avaj.simulator.application.WeatherTower;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

//◦ SUN - Longitude increases with 2, Height increases with 4
//◦ RAIN - Height decreases with 5
//◦ FOG - Height decreases with 3
//◦ SNOW - Height decreases with 15

public class Balloon extends Aircraft implements IFlyable {
    private WeatherTower _weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws RegistrationFailException {
        String weather = _weatherTower.getWeather(_coordinates);
        String msg = "";
        switch (weather) {
            case ("SUN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude() + 2, _coordinates.get_latitude(), _coordinates.get_height() + 4);
                msg = "Let's enjoy the good weather and take some pics.";
                break;
            case ("FOG"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude(), _coordinates.get_height() - 5);
                msg = "Can't see nothing. But i forgot, i'm balloon, i have no eyes.";
                break;
            case ("RAIN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude(), _coordinates.get_height() - 3);
                msg = "Damn you rain! You messed up my baloon.";
                break;
            case ("SNOW"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude(), _coordinates.get_height() - 15);
                msg = "It's snowing. We're gonna crash.";
                break;
        }
        _weatherTower.getMsg(getFullName() + msg);
        if (!checkHeight(_coordinates.get_height())){
            _weatherTower.getMsg(getFullName() + "landing");
            _weatherTower.getMsg("Tower says: " + getFullName() + "unregistered from weather tower.");
            _weatherTower.unregister(this);
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws RegistrationFailException {
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        _weatherTower.getMsg("Tower says: " + getFullName() + "registered to weather tower.");
    }

    public boolean checkHeight(int height){
        return height > 0;
    }
}
