package com.home.thc.Exception;

public class OpenHoursException extends RuntimeException{
    private static final long serialVersionUID = 1;
    public OpenHoursException(String id){
        super(String.format("Open Hours corresponding to Id %s not found", id));
    }
}
