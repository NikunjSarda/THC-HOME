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

    @GetMapping(value = "/OpenHoursList/{page}/{size}", produces = "application/json")
    @ApiOperation(value = "Getting all open hours",
            notes = "Returns all Open Hours")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<OpenHours>> listAllOpenHours(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size){
        return Response.<List<OpenHours>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((openHoursServices.getAll(page, size)))
                .build();
    }

    @GetMapping(value = "/OpenHoursListByLocation/{id}", produces = "application/json")
    @ApiOperation(value = "Getting all open hours",
            notes = "Returns all Open Hours")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<OpenHours>> listAllOpenHoursByLocation(@PathVariable(name = "id") String id){
        return Response.<List<OpenHours>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((openHoursServices.getOpenHoursByLocation(id)))
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

    @PutMapping(value = "/OpenHours/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update a Open Hours",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> updateOpenHours(@PathVariable(name = "id") String id, @RequestBody OpenHoursDTO openHoursDTO){
        return openHoursServices.updateOpenHours(id, openHoursDTO) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Open Hours Updated")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Open Hours Not Updated")
                        .build();
    }

    @DeleteMapping(value = "/OpenHoursDelete/{id}")
    @ApiOperation(value = "Delete a Open Hours",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> deleteOpenHours(@PathVariable(name = "id") String id){
        return openHoursServices.deleteOpenHours(id) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Open Hours deleted")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Open Hours Not deleted")
                        .build();
    }

    @DeleteMapping(value = "/OpenHoursDeleteAll/")
    @ApiOperation(value = "Delete all Open Hours",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> deleteAll(){
        return openHoursServices.deleteAll() == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Open Hours deleted")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Open Hours Not deleted")
                        .build();
    }
}
