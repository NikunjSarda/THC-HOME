package com.home.thc.Services;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Model.Reservation;
import com.home.thc.Repository.ReservationsRepository;
import com.home.thc.Services.Interface.ReservationInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
public class ReservationServices implements ReservationInterface {

    ReservationsRepository reservationsRepo;

    public ReservationServices(ReservationsRepository reservationsRepo){
        this.reservationsRepo = reservationsRepo;
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservationList = new ArrayList<>(reservationsRepo.findAll());
        if (reservationList.isEmpty()) {
            throw new EmptyStackException();
        }
        return reservationList;
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
