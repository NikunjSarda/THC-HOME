package com.home.thc.Exception;

import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {


    @ExceptionHandler(THCException.class)
    public ResponseEntity<Response<?>> handleEmployeesServiceException(THCException e) {
        log.error(e.getMessage());
        return buildResponse();
    }

    private ResponseEntity<Response<?>> buildResponse() {
        var response = Response.builder()
                .meta(ResponseMetaData.builder()
                        .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name())
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
