package com.home.thc.Exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class THCException extends  RuntimeException {
    public static final long serialVersionUID = 1L;

    public THCException(String message, Throwable cause) {
        super(message, cause);
    }

}
