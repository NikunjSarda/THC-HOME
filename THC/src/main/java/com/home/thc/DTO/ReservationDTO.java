package com.home.thc.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationDTO {

    private long id;
    @JsonProperty(value = "customerId")
    private String customerId;
    @JsonProperty(value = "date")
    private Date date;
    @JsonProperty(value = "time")
    private String time;
    @JsonProperty(value = "guests")
    private int guests;
}
