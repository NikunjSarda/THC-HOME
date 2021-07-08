package com.home.thc.Services;

import com.home.thc.DTO.ReservationDTO;
import com.home.thc.Exception.NoDataException;
import com.home.thc.Exception.OpenHoursException;
import com.home.thc.Exception.ReservationException;
import com.home.thc.Exception.THCException;
import com.home.thc.Model.Customer;
import com.home.thc.Model.Location;
import com.home.thc.Model.Reservation;
import com.home.thc.Repository.ReservationsRepository;
import com.home.thc.Services.Interface.ReservationInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ReservationServices implements ReservationInterface {

    ReservationsRepository reservationsRepo;

    public ReservationServices(ReservationsRepository reservationsRepo){
        this.reservationsRepo = reservationsRepo;
    }

    @Override
    public List<Reservation> getAllReservations(int page, int size) {
        log.info("Getting all Reservation");
        Pageable pageable = PageRequest.of(page, size);
        List<Reservation> reservationList = new ArrayList<>(reservationsRepo.findAll(pageable).getContent());
        if (reservationList.isEmpty()) {
            log.error("reservations not found");
            throw new NoDataException();
        }
        log.info("reservations found", reservationList.size());
        return reservationList;
    }

    @Override
    public Reservation getReservationByCustomerEmailId(String id) {
        return reservationsRepo.findReservationByCustomerEmailId(id);
    }

    @Override
    public List<Reservation> getReservationByLocationId(String id) {
        List<Reservation> reservationList = new ArrayList<>(reservationsRepo.findReservationByLocationId(Long.parseLong(id)));
        if (reservationList.isEmpty()) {
            throw new NoDataException();
        }
        return reservationList;
    }

    @Override
    public Boolean createReservation(ReservationDTO reservationDTO) {
        try {
            log.info("Creating new Reservation");
            Reservation reservation = new Reservation();
            Customer customer = new Customer();
            Location location = new Location();
            BeanUtils.copyProperties(reservationDTO.getCustomer(), customer);
            BeanUtils.copyProperties(reservationDTO.getLocation(), location);
            BeanUtils.copyProperties(reservationDTO, reservation);
            reservation.setCustomer(customer);
            reservation.setLocation(location);
            reservationsRepo.save(reservation);
            return Boolean.TRUE;
        }
        catch (Exception e){
            throw new THCException("Internal Server Error", e);
        }
    }

    @Override
    public Boolean updateReservation(String id, ReservationDTO reservationDTO) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationsRepo.findReservationByCustomerEmailId(id));
        if(reservation.isEmpty()) {
            log.error("reservation not found");
            throw new ReservationException(id);
        }
        BeanUtils.copyProperties(reservationDTO, reservation.get());
        reservationsRepo.save(reservation.get());
        log.info("reservation updated for id", id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteReservation(String id) {
        Optional<Reservation> reservation = Optional.ofNullable(reservationsRepo.findReservationByCustomerEmailId(id));
        if(reservation.isEmpty()) {
            log.error("reservation not found");
            throw new ReservationException(id);
        }
        reservationsRepo.delete(reservation.get());
        log.info("reservation removed for id", id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteAll() {
        reservationsRepo.deleteAll();
        return Boolean.TRUE;
    }
}
