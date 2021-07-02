package com.home.thc.Controller;

import com.home.thc.DTO.OpenHoursDTO;
import com.home.thc.Model.OpenHours;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.OpenHoursServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class OpenHoursController {

    OpenHoursServices openHoursServices;

    public OpenHoursController(OpenHoursServices openHoursServices){
        this.openHoursServices = openHoursServices;
    }

    @GetMapping(value = "/OpenHoursList", produces = "application/json")
    @ApiOperation(value = "Getting all open hours",
            notes = "Returns all reservation")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<OpenHours>> listAllOpenHours(){
        return Response.<List<OpenHours>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((openHoursServices.getAll()))
                .build();
    }

    @PostMapping(value = "/OpenHoursCreate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Create a open hours",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> createOpenHours(@RequestBody OpenHoursDTO openHours){
        return openHoursServices.createOpenHours(openHours) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Location Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Location Not Created")
                        .build();
    }
}
