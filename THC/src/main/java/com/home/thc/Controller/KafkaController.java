package com.home.thc.Controller;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.DTO.ReservationStreamDTO;
import com.home.thc.Services.ProducerServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("kafka")
public class KafkaController {

    ProducerServices producerServices;

    public KafkaController(ProducerServices producerServices) {
        this.producerServices = producerServices;
    }

    @PostMapping("/publish/location/reservations")
    public String post(@RequestBody ReservationStreamDTO reservationStreamDTO) {
        log.info("Inside post method, streaming reservation by location id");
        ReservationDTO reservationDTO = reservationStreamDTO.getReservationDTO();
        producerServices.sentReservationLists(reservationStreamDTO);
        return "Published successfully";
    }
}
