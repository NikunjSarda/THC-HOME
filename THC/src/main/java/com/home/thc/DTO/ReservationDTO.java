package com.home.thc.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.home.thc.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationDTO implements Serializable {

    private long id;
    @JsonProperty(value = "date")
    private Date date;
    @JsonProperty(value = "time")
    private String time;
    @JsonProperty(value = "eventName")
    private String eventName;
    @JsonProperty(value = "guests")
    private int guests;

    private CustomerDTO customer;
    private LocationDTO location;
}
