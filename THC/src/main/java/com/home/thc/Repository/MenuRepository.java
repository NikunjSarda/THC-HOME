package com.home.thc.Repository;

import com.home.thc.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    List<Menu> findAll();
    List<Menu> findByType(String type);
    List<Menu> findByItem(String item);
}
