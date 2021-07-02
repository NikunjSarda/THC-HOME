package com.home.thc.Exception;

public class ReservationException extends RuntimeException{
    private static final long serialVersionUID = 1;
    public ReservationException(String id){
        super(String.format("Reservation corresponding to Id %s not found", id));
    }
}
