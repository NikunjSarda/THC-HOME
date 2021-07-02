package com.home.thc.Exception;


public class LocationException extends RuntimeException{
    private static final long serialVersionUID = 1;
    public LocationException(String id){
        super(String.format("Location corresponding to Id %s not found", id));
    }
}
