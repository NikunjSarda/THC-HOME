package com.home.thc.Controller;

import com.home.thc.Model.Location;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.LocationServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Log4j2
public class LocationController {

    LocationServices locationServices;

    public LocationController(LocationServices locationServices){
        this.locationServices = locationServices;
    }

    @GetMapping(value = "/LocationList", produces = "application/json")
    @ApiOperation(value = "Getting all Location",
            notes = "Returns every location")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Location>> listAllLocation(){
        return Response.<List<Location>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((locationServices.getAllLocation()))
                .build();
    }

    @GetMapping(value = "/Location/{id}", produces = "application/json")
    @ApiOperation(value = "Find a location",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<Location> getMenuById(@PathVariable("id") String id){
        return  Response.<Location>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data(locationServices.getByLocationId(id))
                .build();
    }
}
