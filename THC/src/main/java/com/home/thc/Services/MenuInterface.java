package com.home.thc.Services;

import com.home.thc.DTO.MenuDTO;
import com.home.thc.Model.Menu;

import java.util.List;

public interface MenuInterface {

    public Menu getMenuById(String id);
    public List<Menu> getAllMenus();
    public Boolean createMenu(MenuDTO menu);
    public  List<Menu> findByMenuType(String type);
    public  List<Menu> findByMenuItem(String item);
}
