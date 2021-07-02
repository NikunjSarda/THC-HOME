package com.home.thc.Controller;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.ReservationServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
public class ReservationController {

    ReservationServices reservationServices;

    public ReservationController(ReservationServices reservationServices){
        this.reservationServices = reservationServices;
    }

    @GetMapping(value = "/ReservationList", produces = "application/json")
    @ApiOperation(value = "Getting all reservation",
            notes = "Returns all reservation")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<List<Reservation>> listAllReservation(){
        return Response.<List<Reservation>>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((reservationServices.getAllReservations()))
                .build();
    }

    @GetMapping(value = "/CustomerReservation/{customerId}", produces = "application/json")
    @ApiOperation(value = "Getting all reservation",
            notes = "Returns all reservation")
    @ApiResponses(value= {
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<Reservation> customerReservation(@PathVariable(name = "customerId") String customerId){
        return Response.<Reservation>builder()
                .meta(ResponseMetaData.builder()
                        .statusCode(200)
                        .statusMessage(StatusMessage.SUCCESS.name()).build())
                .data((reservationServices.getReservationById(customerId)))
                .build();
    }

    @PostMapping(value = "/ReservationCreate", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Create a Reservation",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> createReservation(@RequestBody ReservationDTO reservation){
        return reservationServices.createReservation(reservation) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Reservation Created")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Reservation Not Created")
                        .build();
    }

    @PutMapping(value = "/ReservationUpdate/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update a Reservation",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> updateReservation(@PathVariable(name = "id") String id, @RequestBody ReservationDTO reservationDTO){
        return reservationServices.updateReservation(id, reservationDTO) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Reservation Updated")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Reservation Not Updated")
                        .build();
    }

    @DeleteMapping(value = "/ReservationDelete/{id}")
    @ApiOperation(value = "Delete a Reservation",
            notes = "provide necessary details")
    @ApiResponses(value= {
            @ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR"),
            @ApiResponse(code = 200, message = "OK")
    })
    public Response<String> deleteReservation(@PathVariable(name = "id") String id){
        return reservationServices.deleteReservation(id) == Boolean.TRUE ?
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.SUCCESS.name()).build())
                        .data("Reservation deleted")
                        .build()
                :
                Response.<String>builder()
                        .meta(ResponseMetaData.builder()
                                .statusCode(200)
                                .statusMessage(StatusMessage.UNKNOWN_INTERNAL_ERROR.name()).build())
                        .data("Reservation Not deleted")
                        .build();
    }
}
