package com.home.thc.Services;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;

import java.util.List;

public interface ReservationInterface {

    public List<Reservation> getAllReservations();
    public Reservation getReservationById(String id);
    public Boolean createReservation(ReservationDTO reservation);
    public Boolean updateReservation(String id, ReservationDTO menu);
    public Boolean deleteReservation(String id);
}
