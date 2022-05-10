package edu.school21.avaj.simulator.aircraft;

public class AirFactory {

    public static IFlyable newAircraft(String type, String name, int longitude, int latitude,int height){
        switch (type){
            case ("Ballon"):
                return new Balloon(name, new Coordinates(longitude, latitude, height));
            case ("JetPlane"):
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case ("Helicopter"):
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                System.out.println("Unknown type");
                return null;
        }
    }
}
