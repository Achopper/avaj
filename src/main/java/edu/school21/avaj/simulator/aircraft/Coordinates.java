package edu.school21.avaj.simulator.aircraft;

import edu.school21.avaj.simulator.exeptions.IllegalCoordinatesExeption;

public class Coordinates {
    private int         _longitude;
    private int         _latitude;
    private int         _height;

    Coordinates(int longitude, int latitude, int height) {
        if (longitude < 0 || latitude < 0)
            throw new IllegalCoordinatesExeption("Illegal coordinates value");
        _longitude = longitude;
        _latitude = latitude;
        _height = Math.min(height, 100);
    }

    public int get_longitude() {
        return _longitude;
    }

    public int get_latitude() {
        return _latitude;
    }

    public int get_height() {
        return _height;
    }
}
