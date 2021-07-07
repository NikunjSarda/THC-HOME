package com.home.thc.Repository;

import com.home.thc.Model.Menu;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends PagingAndSortingRepository<Menu, Long> {

    @NotNull
    Page<Menu> findAll(@NotNull Pageable pageable);
    List<Menu> findByName(String name);
    List<Menu> findByType(String type);
}
