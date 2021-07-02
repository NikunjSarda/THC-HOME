package com.home.thc.Services;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Exception.MenuException;
import com.home.thc.Model.Menu;
import com.home.thc.Repository.MenuRepository;
import com.home.thc.Services.Interface.MenuInterface;
import org.springframework.beans.BeanUtils;
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
    public List<Menu> getAllMenus() {
        List<Menu> menuList = new ArrayList<>(menuRepo.findAll());
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
        return null;
    }

    @Override
    public List<Menu> findByMenuType(String type) {
        return null;
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
        if(!menu.isPresent()) {
            throw new MenuException(id);
        }
        BeanUtils.copyProperties(menuDTO, menu.get());
        menuRepo.save(menu.get());
        return Boolean.TRUE;
    }


}
