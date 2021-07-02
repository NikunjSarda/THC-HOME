package com.home.thc.Controller;

import com.home.thc.Model.Menu;
import com.home.thc.Model.Reservation;
import com.home.thc.Response.Response;
import com.home.thc.Response.ResponseMetaData;
import com.home.thc.Response.StatusMessage;
import com.home.thc.Services.ReservationServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
