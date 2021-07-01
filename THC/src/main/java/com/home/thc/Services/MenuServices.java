package com.home.thc.Services;

import com.home.thc.Exception.MenuException;
import com.home.thc.Model.Menu;
import com.home.thc.Repository.MenuRepository;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
@Log4j2
public class MenuServices implements MenuInterface {

    MenuRepository menuRepo;

    public MenuServices(MenuRepository menuRepo){
        this.menuRepo = menuRepo;
    }

    @Override
    public List<Menu> findAllMenus() {
        List<Menu> menuList = new ArrayList<>();
        menuRepo.findAll().forEach(menuList :: add);
        if(menuList.isEmpty()){
            throw new EmptyStackException();
        }
        return menuList;
    }

    @Override
    public Menu getMenuById(String id) {
        return menuRepo.findById(id).orElseThrow(() -> new MenuException(id));
    }

    @Override
    public Menu createMenu(MenuInterface menu) {
        return null;
    }

    @Override
    public List<Menu> findByMenuType(String type) {
        return null;
    }

    @Override
    public List<Menu> findByMenuItem(String item) {
        return null;
    }
}
