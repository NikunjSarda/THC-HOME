package com.home.thc.Services;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;
import com.home.thc.Services.Interface.ReservationInterface;

import java.util.List;

public class ReservationServices implements ReservationInterface {

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public Reservation getReservationById(String id) {
        return null;
    }

    @Override
    public Boolean createReservation(ReservationDTO reservation) {
        return null;
    }

    @Override
    public Boolean updateReservation(String id, ReservationDTO menu) {
        return null;
    }

    @Override
    public Boolean deleteReservation(String id) {
        return null;
    }
}
