package edu.school21.avaj.simulator.aircraft;

import com.sun.deploy.association.RegisterFailedException;
import edu.school21.avaj.simulator.tower.weatherTower.WeatherTower;

//◦ SUN - Latitude increases with 10, Height increases with 2
//◦ RAIN - Latitude increases with 5
//◦ FOG - Latitude increases with 1
//◦ SNOW - Height decreases with 7

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = _weatherTower.getWeather(_coordinates);
        String msg = "";
        switch (weather) {
            case ("SUN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude() + 10, _coordinates.get_height() + 2);
                msg = "I hope someday in Russia we will have the same weather";
                break;
            case ("FOG"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude() + 1, _coordinates.get_height());
                msg = "Where am I going? Up or down?";
                break;
            case ("RAIN"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude() + 5, _coordinates.get_height());
                msg = "It's raining. Better watch out for lightnings.";
                break;
            case ("SNOW"):
                _coordinates = new Coordinates
                        (_coordinates.get_longitude(), _coordinates.get_latitude(), _coordinates.get_height() - 10);
                msg = "OMG! Winter is coming!";
                break;
        }
        _weatherTower.getMsg(getFullName() + msg);
        if (!checkHeight(_coordinates.get_height())){
            _weatherTower.getMsg(getFullName() + "landing");
            _weatherTower.getMsg("Tower says: " + getFullName() + "unregistered from weather tower.");
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws RegisterFailedException {
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        _weatherTower.getMsg("Tower says: " + getFullName() + "registered to weather tower.");
    }

    public boolean checkHeight(int height){
        return height > 0;
    }
}
