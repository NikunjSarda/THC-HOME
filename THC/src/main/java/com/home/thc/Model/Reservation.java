package com.home.thc.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation implements Serializable {

    @Id
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private String time;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "guests")
    private int guests;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Location location;
}
