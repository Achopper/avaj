package edu.school21.avaj.simulator.tower;

import com.sun.deploy.association.RegisterFailedException;
import edu.school21.avaj.simulator.aircraft.IFlyable;

import java.util.ArrayList;

public class Tower {
    private final ArrayList<IFlyable> OBSERVERS = new ArrayList<>();

    public void register(IFlyable flyable) throws RegisterFailedException {
        if (OBSERVERS.contains(flyable))
            throw new RegisterFailedException("Aircraft alreafy register");
        OBSERVERS.add(flyable);
    }

    public void unregister(IFlyable flyable) throws RegisterFailedException {
        if (OBSERVERS.contains(flyable))
            throw new RegisterFailedException("Aircraft alreafy register");
        OBSERVERS.remove(flyable);
    }

    protected void conditionChange(){
        for (IFlyable fl : OBSERVERS) {
            fl.updateConditions();
        }
    }
}
