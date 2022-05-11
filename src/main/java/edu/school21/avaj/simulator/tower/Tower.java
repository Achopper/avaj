package edu.school21.avaj.simulator.tower;

import edu.school21.avaj.simulator.aircraft.IFlyable;
import edu.school21.avaj.simulator.exeptions.RegistrationFailException;

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

    protected void conditionChange() throws RegistrationFailException {
        for (IFlyable fl : OBSERVERS) {
            fl.updateConditions();
        }
        for (IFlyable fl : un){
            OBSERVERS.remove(fl);
        }
    }
}
