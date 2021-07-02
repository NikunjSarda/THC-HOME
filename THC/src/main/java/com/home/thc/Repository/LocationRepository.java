package com.home.thc.Repository;

import com.home.thc.Model.Location;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @NotNull
    List<Location> findAll();
    Location findByName(String name);
}
