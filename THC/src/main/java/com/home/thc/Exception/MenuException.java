package com.home.thc.Exception;

public class MenuException extends RuntimeException{

    private static final long serialVersionUID = 1;
    public MenuException(String id){
        super(String.format("Menu corresponding to Id %s not found", id));
    }
}
