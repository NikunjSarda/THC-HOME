package com.home.thc.Services.Interface;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;

import java.util.List;

public interface ReservationInterface {

    List<Reservation> getAllReservations(int page, int size);
    Reservation getReservationByCustomerEmailId(String id);
    List<Reservation> getReservationByLocationId(String id);
    Boolean createReservation(ReservationDTO reservation);
    Boolean updateReservation(String id, ReservationDTO menu);
    Boolean deleteReservation(String id);
    Boolean deleteAll();
}
