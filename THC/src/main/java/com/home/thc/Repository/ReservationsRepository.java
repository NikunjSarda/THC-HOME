package com.home.thc.Repository;

import com.home.thc.Model.Reservation;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends PagingAndSortingRepository<Reservation, Long> {

    @NotNull
    Page<Reservation> findAll(@NotNull Pageable pageable);
    Reservation findReservationByCustomerEmailId(String customerEmailId);
    List<Reservation> findReservationByLocationId(long id);
}
