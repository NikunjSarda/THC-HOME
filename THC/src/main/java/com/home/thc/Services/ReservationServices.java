package com.home.thc.Services;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Exception.ReservationException;
import com.home.thc.Model.Reservation;
import com.home.thc.Repository.ReservationsRepository;
import com.home.thc.Services.Interface.ReservationInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

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
        return reservationsRepo.findByCustomerId(id);
    }

//    @Override
//    public List<Reservation> getReservationByLocation(String id) {
//        //TODO
//        return null;
//    }

    @Override
    public Boolean createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDTO, reservation);
        reservationsRepo.save(reservation);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateReservation(String id, ReservationDTO reservationDTO) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationsRepo.findByCustomerId(id));
        if(reservation.isEmpty()) {
            throw new ReservationException(id);
        }
        BeanUtils.copyProperties(reservationDTO, reservation.get());
        reservationsRepo.save(reservation.get());
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteReservation(String id) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationsRepo.findByCustomerId(id));
        if(reservation.isEmpty()) {
            throw new ReservationException(id);
        }
        reservationsRepo.delete(reservation.get());
        return Boolean.TRUE;
    }
}
