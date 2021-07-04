package com.home.thc.Services.Interface;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;

import java.util.List;

public interface ReservationInterface {

    List<Reservation> getAllReservations();
    Reservation getReservationByCustomerEmailId(String id);
//    List<Reservation> getReservationByLocation(String id);
    Boolean createReservation(ReservationDTO reservation);
    Boolean updateReservation(String id, ReservationDTO menu);
    Boolean deleteReservation(String id);
    Boolean deleteAll();
}
