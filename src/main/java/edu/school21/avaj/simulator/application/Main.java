package edu.school21.avaj.simulator.application;



import edu.school21.avaj.simulator.aircraft.AirFactory;
import edu.school21.avaj.simulator.aircraft.IFlyable;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static Integer               numOfSimulations;
    public static ArrayList<String>     args = new ArrayList<>();
    private static final WeatherTower   TOWER = new WeatherTower();
    public static BufferedWriter        writer;

    public static void main(String[] args) {
        try {
            if (args.length != 1)
                throw new IllegalArgumentException("Wrong num of arguments: Usage: [path/to/scenario.txt]");
            new argValidator().validate("/" + args[0]);
            writer = new BufferedWriter(new FileWriter("../../../result.txt"));
            startSimulation(numOfSimulations);
            writer.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static void startSimulation(int numOfIterations) throws RegistrationFailException, IOException {
        String[] splitArg;
        for (String param : args) {
            splitArg = param.split(" ");
            IFlyable obj = AirFactory.newAircraft(splitArg[0],
                    splitArg[1],
                    Integer.parseInt(splitArg[2]),
                    Integer.parseInt(splitArg[3]),
                    Integer.parseInt(splitArg[4]));
            obj.registerTower(TOWER);
        }
        for (; numOfIterations > 0; --numOfIterations){
         writer.append("------------------SIMULATION #").append(String.valueOf(numOfIterations)).append("----------------------------\n");
               TOWER.changeWeather();
            }

    }
}

//positive number = how many times weather change
//TYPE NAME LONGITUDE LATITUDE HEIGHT.
