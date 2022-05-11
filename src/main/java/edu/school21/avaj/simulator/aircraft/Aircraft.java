package edu.school21.avaj.simulator.aircraft;

public class Aircraft {
    protected long              _id;
    protected String            _name;
    protected Coordinates       _coordinates;
    private static long         _idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates){
        _id = nextId();
        _name = name;
        _coordinates = coordinates;
    }

    private long nextId(){
        return (_idCounter++);
    }

    protected String getFullName(){
        return (getClass().getSimpleName() + "#" + _name + "(" + _id + "): ");
    }
}
