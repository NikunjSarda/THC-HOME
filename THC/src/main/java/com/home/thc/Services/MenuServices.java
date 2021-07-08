package com.home.thc.Services;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Exception.MenuException;
import com.home.thc.Exception.NoDataException;
import com.home.thc.Exception.THCException;
import com.home.thc.Model.Menu;
import com.home.thc.Repository.MenuRepository;
import com.home.thc.Services.Interface.MenuInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MenuServices implements MenuInterface {

    MenuRepository menuRepo;

    public MenuServices(MenuRepository menuRepo){
        this.menuRepo = menuRepo;
    }

    @Override
    public List<Menu> getAllMenus(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        List<Menu> menuList = new ArrayList<>(menuRepo.findAll(pageable).getContent());
        if (menuList.isEmpty()) {
            log.error("menu not found");
            throw new NoDataException();
        }
        log.info("menus found", menuList.size());
        return menuList;
    }

    @Override
    public Menu getMenuById(String id) {
        log.info("menu found by id:", id);
        return menuRepo.findById(Long.parseLong(id)).orElseThrow(() -> new MenuException(id));
    }

    @Override
    public List<Menu> findByMenuName(String name) {
        List<Menu> menuList = new ArrayList<>(menuRepo.findByName(name));
        if (menuList.isEmpty()) {
            log.error("menu not found");
            throw new NoDataException();
        }
        log.info("menus found by name", menuList.size());
        return menuList;
    }

    @Override
    public List<Menu> findByMenuType(String type) {
        List<Menu> menuList = new ArrayList<>(menuRepo.findByType(type));
        if (menuList.isEmpty()) {
            log.error("menu not found");
            throw new EmptyStackException();
        }
        log.info("menus found by name", menuList.size());
        return menuList;
    }
    @Override
    public Boolean createMenu(MenuDTO menuDTO) {
       try {
           log.info("Creating menu");
           Menu menu = new Menu();
           BeanUtils.copyProperties(menuDTO, menu);
           menuRepo.save(menu);
           return Boolean.TRUE;
       }
       catch (Exception e){
           throw new THCException("Internal Server Error", e);
       }
    }

    @Override
    public Boolean updateMenu(String id, MenuDTO menuDTO) {
        Optional<Menu> menu = menuRepo.findById(Long.parseLong(id));
        if(menu.isEmpty()) {
            log.error("menu not found");
            throw new MenuException(id);
        }
        BeanUtils.copyProperties(menuDTO, menu.get());
        menuRepo.save(menu.get());
        log.info("menus updated for id:", id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteMenu(String id) {
        Optional<Menu> menu = menuRepo.findById(Long.parseLong(id));
        if(menu.isEmpty()) {
            log.error("menu not found");
            throw new MenuException(id);
        }
        menuRepo.delete(menu.get());
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteAll() {
        menuRepo.deleteAll();
        return Boolean.TRUE;
    }


}
