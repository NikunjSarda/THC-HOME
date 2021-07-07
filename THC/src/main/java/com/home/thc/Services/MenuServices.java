package com.home.thc.Services;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Exception.MenuException;
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
            throw new EmptyStackException();
        }
        return menuList;
    }

    @Override
    public Menu getMenuById(String id) {
        return menuRepo.findById(Long.parseLong(id)).orElseThrow(() -> new MenuException(id));
    }

    @Override
    public List<Menu> findByMenuName(String name) {
        List<Menu> menuList = new ArrayList<>(menuRepo.findByName(name));
        if (menuList.isEmpty()) {
            throw new EmptyStackException();
        }
        return menuList;
    }

    @Override
    public List<Menu> findByMenuType(String type) {
        List<Menu> menuList = new ArrayList<>(menuRepo.findByType(type));
        if (menuList.isEmpty()) {
            throw new EmptyStackException();
        }
        return menuList;
    }
    @Override
    public Boolean createMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        menuRepo.save(menu);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateMenu(String id, MenuDTO menuDTO) {
        Optional<Menu> menu = menuRepo.findById(Long.parseLong(id));
        if(menu.isEmpty()) {
            throw new MenuException(id);
        }
        BeanUtils.copyProperties(menuDTO, menu.get());
        menuRepo.save(menu.get());
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteMenu(String id) {
        Optional<Menu> menu = menuRepo.findById(Long.parseLong(id));
        if(menu.isEmpty()) {
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
