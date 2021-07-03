package com.home.thc.Controller;

import com.home.thc.Model.Interceptor;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.InterceptorServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class InterceptorController {

    InterceptorServices interceptorServices;

    public InterceptorController(InterceptorServices interceptorServices){
        this.interceptorServices = interceptorServices;
    }

    @GetMapping(value = "/InterceptorURL", produces = "application/json")
    @ApiOperation(value = "Getting api time details by service name",
            notes = "Returns execution time of api")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Interceptor>> getInterceptorByUrl(@RequestParam String url){
        return Response.<List<Interceptor>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((interceptorServices.getInterceptorByUrl(url)))
                .build();
    }

    @GetMapping(value = "/InterceptorDate/{date}", produces = "application/json")
    @ApiOperation(value = "Getting execution time details by date",
            notes = "Provide date, format MMM DD,YYYY HH:MM")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Interceptor>> getInterceptorByDate(@PathVariable(name = "date") String date){
        return Response.<List<Interceptor>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((interceptorServices.getInterceptorByDate(date)))
                .build();
    }

}
