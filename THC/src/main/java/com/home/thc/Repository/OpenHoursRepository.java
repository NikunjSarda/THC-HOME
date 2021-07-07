package com.home.thc.Repository;

import com.home.thc.Model.OpenHours;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenHoursRepository extends PagingAndSortingRepository<OpenHours, Long> {

    @NotNull
    Page<OpenHours> findAll(@NotNull Pageable pageable);
}
