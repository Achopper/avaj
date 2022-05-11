package edu.school21.avaj.simulator.exeptions;

public class RegistrationFailException extends RuntimeException{
    public RegistrationFailException(String msg){
        super(msg);
    }
}
