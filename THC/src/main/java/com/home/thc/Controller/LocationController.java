package com.home.thc.Controller;

import com.home.thc.DTO.LocationDTO;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
public class LocationController {

    LocationServices locationServices;

    public LocationController(LocationServices locationServices){
        this.locationServices = locationServices;
    }

    @GetMapping(value = "/LocationList", produces = "application/json")
    @ResponseBody
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

    @GetMapping(value = "/LocationById/{id}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Find a location",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<Location> getLocationById(@PathVariable("id") String id){
        return  Response.<Location>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data(locationServices.getByLocationId(id))
                .build();
    }

    @GetMapping(value = "/LocationByName/{name}", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Get Location by name",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Location>> getLocationByName(@PathVariable("name") String name){
        return  Response.<List<Location>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((locationServices.findByLocationName(name)))
                .build();
    }

    @PostMapping(value = "/LocationCreate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Create a Location",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> createLocation(@RequestBody LocationDTO location){
        return locationServices.createLocation(location) == Boolean.TRUE ?
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

    @PutMapping(value = "/LocationUpdate/{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "Update a location",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "UPDATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> updateLocation(@PathVariable(name = "id") String id, @RequestBody LocationDTO location){
        return locationServices.updateLocation(id, location) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("location Updated")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("location Not Updated")
                        .build();
    }

    @DeleteMapping(value = "/LocationDelete/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete a Location",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "DELETED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> deleteLocation(@PathVariable(name = "id") String id){
        return locationServices.deleteLocation(id) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("location deleted")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("location Not deleted")
                        .build();
    }
}
