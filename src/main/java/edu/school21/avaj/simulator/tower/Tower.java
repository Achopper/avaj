package edu.school21.avaj.simulator.tower;

import edu.school21.avaj.simulator.aircraft.IFlyable;
import edu.school21.avaj.simulator.application.Main;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

import java.io.IOException;
import java.util.ArrayList;

public class Tower {
    private final ArrayList<IFlyable> OBSERVERS = new ArrayList<>();
    private final ArrayList<IFlyable> un = new ArrayList<>();

    public void register(IFlyable flyable) throws RegistrationFailException {
        if (OBSERVERS.contains(flyable))
            throw new RegistrationFailException("Aircraft alreafy register");
        OBSERVERS.add(flyable);
    }

    public void unregister(IFlyable flyable) throws RegistrationFailException {
        if (!OBSERVERS.contains(flyable))
            throw new RegistrationFailException("This aircraft not register");
        un.add(flyable);
    }

    protected void conditionChange() throws RegistrationFailException, IOException {
        for (IFlyable fl : OBSERVERS) {
            fl.updateConditions();
        }
        for (IFlyable fl : un){
            OBSERVERS.remove(fl);
        }
        if  (OBSERVERS.isEmpty()){
            Main.numOfSimulations = 0;
            Main.writer.write("---------------------All aircraft landed---------------------");
            Main.writer.close();
            System.exit(1);
        }
    }
}
