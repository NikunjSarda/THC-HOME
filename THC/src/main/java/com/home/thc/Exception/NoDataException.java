package com.home.thc.Exception;

public class NoDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NoDataException() {
        super("No data found for the EndPoint");
    }
}