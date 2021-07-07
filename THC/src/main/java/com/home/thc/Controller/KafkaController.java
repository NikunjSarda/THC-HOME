package com.home.thc.Controller;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.DTO.ReservationStreamDTO;
import com.home.thc.Model.User;
import com.home.thc.Services.ProducerServices;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    ProducerServices producerServices;

    public KafkaController(ProducerServices producerServices) {
        this.producerServices = producerServices;
    }

    @PostMapping("/publish/loaction/reservations")
    public String post(@RequestBody ReservationStreamDTO reservationStreamDTO) {
        ReservationDTO reservationDTO = reservationStreamDTO.getReservationDTO();
        producerServices.sentReservationLists(reservationStreamDTO);
        return "Published successfully";
    }
}
