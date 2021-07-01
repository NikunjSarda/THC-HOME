package com.home.thc.Services;

import com.home.thc.Model.Menu;

import java.util.List;

public interface MenuInterface {

    public Menu getMenuById(String id);
    public List<Menu> findAllMenus();
    public Menu createMenu(MenuInterface menu);
    public  List<Menu> findByMenuType(String type);
    public  List<Menu> findByMenuItem(String item);
}
