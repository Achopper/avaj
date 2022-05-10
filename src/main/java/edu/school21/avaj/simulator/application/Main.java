package edu.school21.avaj.simulator.application;

import edu.school21.avaj.simulator.aircraft.Aircraft;
import edu.school21.avaj.simulator.aircraft.Helicopter;

import java.util.ArrayList;

public class Main {
    public static Integer               numOfSimulations;
    public  static ArrayList<String>    args = new ArrayList<>();

    public static void main(String[] args) {
        try {
            if (args.length != 1)
                throw new IllegalArgumentException("Wrong num of arguments: Usage: [path/to/scenario.txt]");
            new argValidator().validate(new String("/" + args[0]));
            startSimulation(numOfSimulations);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static void startSimulation(int numOfIterations){
        for (; numOfIterations > 0; --numOfIterations){
            for (String param : args) {

            }
        }
    }
}

//positive number = how many times weather change
//TYPE NAME LONGITUDE LATITUDE HEIGHT.
