package edu.school21.avaj.simulator.aircraft;


import edu.school21.avaj.simulator.application.WeatherTower;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

//◦ SUN - Longitude increases with 10, Height increases with 2
//◦ RAIN - Longitude increases with 5
//◦ FOG - Longitude increases with 1
//◦ SNOW - Height decreases with 12

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower _weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() throws RegistrationFailException {
       String weather = _weatherTower.getWeather(_coordinates);
        String msg = "";
        switch (weather) {
            case ("SUN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude() + 10, _coordinates.get_latitude(), _coordinates.get_height() + 2);
                msg = "This is hot.";
                break;
            case ("FOG"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude() + 5, _coordinates.get_latitude(), _coordinates.get_height());
                msg = "Visible-zero! Going by the instruments";
                break;
            case ("RAIN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude() + 1, _coordinates.get_latitude(), _coordinates.get_height());
                msg = "Damn you rain!";
                break;
            case ("SNOW"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude(), _coordinates.get_height() - 12);
                msg = " My rotor is going to freeze!";
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
