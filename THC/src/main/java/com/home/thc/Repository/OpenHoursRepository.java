package com.home.thc.Repository;

import com.home.thc.Model.OpenHours;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenHoursRepository extends JpaRepository<OpenHours, Long> {

    @NotNull
    List<OpenHours> findAll();
}
