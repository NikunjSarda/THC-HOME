package com.home.thc.Repository;

import com.home.thc.Model.Location;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

    @NotNull
    Page<Location> findAll(@NotNull Pageable pageable);
    List<Location> findByName(String name);
}
