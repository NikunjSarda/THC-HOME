package com.home.thc.Repository;

import com.home.thc.Model.Menu;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @NotNull
    List<Menu> findAll();
}
