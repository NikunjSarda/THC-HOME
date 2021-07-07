package com.home.thc.Services;

import com.home.thc.DTO.ReservationStreamDTO;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Log4j2
public class ProducerServices {

    private final KafkaTemplate<String, ReservationStreamDTO> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";


    public ProducerServices(KafkaTemplate<String, ReservationStreamDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sentReservationLists(ReservationStreamDTO reservationStreamDTO){
        kafkaTemplate.executeInTransaction(t -> {
            ListenableFuture<SendResult<String, ReservationStreamDTO>> future = t.send(TOPIC, Long.toString(reservationStreamDTO.getReservationDTO().getLocation().getId()), reservationStreamDTO);
            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult<String, ReservationStreamDTO> result) {
                    log.info("Sent message=[ {} ] with offset=[ {} ] to the Topic", reservationStreamDTO, result.getRecordMetadata().offset());
                }

                @Override
                public void onFailure(@NotNull Throwable ex) {
                    log.info("Unable to produce message=[ {} ] due to : {}", reservationStreamDTO, ex.getMessage());
                }
            });
            return true;
        });
    }
}
