package com.home.thc.Repository;

import com.home.thc.Model.Reservation;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

    @NotNull
    List<Reservation> findAll();
}
